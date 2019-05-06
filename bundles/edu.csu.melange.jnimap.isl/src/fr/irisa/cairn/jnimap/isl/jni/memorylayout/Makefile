
all:
	-rm *.aux *.bbl *.bib *.blg *.log *.toc *.out
	pdflatex memory_allocation.tex
	bibtex memory_allocation
	pdflatex memory_allocation.tex
	pdflatex memory_allocation.tex
	-rm *.aux *.bbl *.bib *.blg *.log *.toc *.out

clean:
	-rm *.aux *.bbl *.bib *.blg *.log *.toc *.out