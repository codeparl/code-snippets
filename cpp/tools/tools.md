# Tools Required to Run C++ Code Snippets

To compile and run the C++ code snippets in this repository, you need a C++ compiler and build tools. We recommend using **MSYS2** for Windows, which provides the GCC (g++) compiler and other essential tools.

## Download and Install MSYS2

1. Download the MSYS2 installer from the following link:
	[msys2-x86_64-20241208.exe](https://www.msys2.org/)

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
