#include <iostream>

int myMultiply(int num){
    return num * 2;
}

int main(){

    std::cout << "Enter an integer: ";

    int num { };
    std::cin >> num;

    int doubleNum { myMultiply(num) };
    std::cout << "Double that number is: " << doubleNum << std::endl;

    return 0;
}
