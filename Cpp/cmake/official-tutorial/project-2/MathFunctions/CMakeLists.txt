# TODO 14: Remove mysqrt.cxx from the list of sources

# Add the MathFunctions library to the project
add_library(MathFunctions MathFunctions.cxx)

# TODO 7: Create a variable USE_MYMATH using option and set default to ON
option(USE_MYMATH "Use the custom function to calculate square root" ON)

# TODO 8: If USE_MYMATH is ON, use target_compile_definitions to pass
# USE_MYMATH as a precompiled definition to our source files
if(USE_MYMATH)
  target_compile_definitions(MathFunctions PRIVATE "USE_MYMATH")

# TODO 12: When USE_MYMATH is ON, add a library for SqrtLibrary with
# source mysqrt.cxx
  add_library(SqrtLibrary STATIC mysqrt.cxx)

  target_link_libraries(MathFunctions PRIVATE SqrtLibrary)
endif()

# TODO 13: When USE_MYMATH is ON, link SqrtLibrary to the MathFunctions Library
