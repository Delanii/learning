cmake_minimum_required(VERSION 3.10)

# Define the project name and version
project(Tutorial
  VERSION 1.0)

# Set C++ standard -- it seems like this is actually not a recommended practice
set(CMAKE_CXX_STANDARD 11)
set(CMAKE_CXX_STANDARD_REQUIRED True)

# THe `.h.in` fie is an autoconf file.
# It replaces variables delimited by `@` in the header file with their values, and produces the files header file.
configure_file(TutorialConfig.h.in TutorialConfig.h)

# Define the final executable built from the file with the main entry point.
add_executable(tutorial tutorial.cxx)

target_include_directories(tutorial
  PUBLIC ${PROJECT_BINARY_DIR})
