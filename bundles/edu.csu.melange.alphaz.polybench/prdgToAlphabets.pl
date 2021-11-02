#!/usr/bin/perl

my $INPUT = $ARGV[0];
my $DATA_TYPE = 'DATA_TYPE';

if (!($INPUT =~ /.+\.prdg/)) {
	printf("Invalid input :%s\n", $INPUT);
	exit 0;
}

if ($#ARGV >= 1) {
	$DATA_TYPE = $ARGV[1];
}

my $system = $INPUT;
$system =~ s/\.prdg//;

open IN, $INPUT;
my @lines = <IN>;
close IN;

my $paramDom;
my $varDecls;

my $prdgSection = 0;
my $prdgLine;
foreach $line (@lines) {
	if ($line =~ /Domains :/) {
		($paramDom, $varDecls) = &parseDomains($line);
	}
	$prdgLine .= $line if ($prdgSection);
	$prdgSection = 1 if ($line =~ /PRDG \(simplified\) :/);
}

$prdgLine =~ s/\n//g;

my $equations = &parsePRDG($prdgLine);

my $output = 'affine '.$system.' '.$paramDom."\n";
$output .= 'using'."\n";
$output .= $varDecls;
$output .= 'through'."\n";
$output .= $equations;
$output .= '.'."\n";
print $output;

sub parseDomains() {
	my $domains = $_[0];
	$domains =~ s/ and / && /g;
	$domains =~ s/\s//g;
	$domains =~ s/^.+Domains://;

	$domains =~ /\[(.+)\]->\{(.+)\}/;

	my $params = '{'.$1.'|}';
	my $domains = $2;

	my @vars;

	while ($domains =~ /(S\d+)\[([^\]]*)\](?::([^;]+))?(?:;(.+))?/) {
		my $stmt = $1;
		my $indices = $2;
		my $constraints = $3;
		$domains = $4;

		push @var, "$DATA_TYPE $stmt {$indices|$constraints}";
	}

	my $varDecls;
	foreach $v (sort @var) {
		$varDecls .= $v.";\n";
	}

	return ($params, $varDecls);
}

sub parsePRDG() {
	my $prdg = $_[0];
	$prdg =~ s/ and / && /g;
	$prdg =~ s/\s//g;

	my @eqs;

	while ($prdg =~ /(S\d+)\[([^\]]*)\]->(S\d+)\[([^\]]*)\](?::([^;]+))?(?:;(.+))?/) {
		my $consumer = $1;
		my $consumerIndices = $2;
		my $producer = $3;
		my $producerIndices = $4;
		my $constraints = $5;
		$prdg = $6;

		push @eqs, $consumer.'['.$consumerIndices.'] = {'.$consumerIndices.'|'.$constraints.'} : '.$producer.'['.$producerIndices.']';
	}

	my $equations;
	foreach $eq (sort @eqs) {
		$equations .= $eq.";\n";
	}

	return $equations;
}

