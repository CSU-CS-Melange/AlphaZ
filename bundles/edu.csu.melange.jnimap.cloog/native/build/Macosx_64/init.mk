# detect intel vs. arm macs
ifeq ($(shell sysctl -a hw.optional.x86_64 | cut -d" " -f2),1)
	ARCH_TYPE = x86_64
else ifeq ($(shell sysctl -a hw.optional.arm64 | cut -d" " -f2),1)
  ARCH_TYPE = arm64
else 
	ARCH_TYPE = 64
endif

ARCH = 64
