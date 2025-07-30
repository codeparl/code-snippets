# Tools Required to Run C++ Code Snippets

To compile and run the C++ code snippets in this repository, you need a C++ compiler and build tools. We recommend using **MSYS2** for Windows, which provides the GCC (g++) compiler and other essential tools.

## Download and Install MSYS2

1. Download the MSYS2 installer from the following link:
	[msys2-x86_64-20241208.exe](https://release-assets.githubusercontent.com/github-production-release-asset/80988227/cedfe079-9fca-44f4-b2bf-021f8f8107e2?sp=r&sv=2018-11-09&sr=b&spr=https&se=2025-07-29T04%3A32%3A02Z&rscd=attachment%3B+filename%3Dmsys2-x86_64-20241208.exe&rsct=application%2Foctet-stream&skoid=96c2d410-5711-43a1-aedd-ab1947aa7ab0&sktid=398a6654-997b-47e9-b12b-9515b896b4de&skt=2025-07-29T03%3A31%3A30Z&ske=2025-07-29T04%3A32%3A02Z&sks=b&skv=2018-11-09&sig=d0bCLpyNXVCU%2FFy3wzvpk5smdWZZ7994iyP33F2kkSM%3D&jwt=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJnaXRodWIuY29tIiwiYXVkIjoicmVsZWFzZS1hc3NldHMuZ2l0aHVidXNlcmNvbnRlbnQuY29tIiwia2V5Ijoia2V5MSIsImV4cCI6MTc1Mzc2MTczMiwibmJmIjoxNzUzNzYxNDMyLCJwYXRoIjoicmVsZWFzZWFzc2V0cHJvZHVjdGlvbi5ibG9iLmNvcmUud2luZG93cy5uZXQifQ.G2T1Lm4V77yxM9pXTwaJXO3v8FXEgn9kXEq6pCsV5pg&response-content-disposition=attachment%3B%20filename%3Dmsys2-x86_64-20241208.exe&response-content-type=application%2Foctet-stream)

2. Run the installer and follow the instructions on the [official MSYS2 installation guide](https://www.msys2.org/docs/).

3. After installation, open the MSYS2 terminal and update the package database and core system packages:

	```sh
	pacman -Syu
	```

4. Install the GCC compiler and make tool:

	```sh
	pacman -S --needed base-devel mingw-w64-x86_64-toolchain
	```

5. Add the MSYS2 `mingw64` bin directory to your system `PATH` to use `g++` from any terminal.

## Verifying Installation

To verify that `g++` is installed and available, run:

```sh
g++ --version
```

You should see the GCC version information.

---

You are now ready to compile and run the C++ code snippets in this repository.
