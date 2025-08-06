#include <iostream>
#include  "Account.h"

using namespace  std;
int main(){

Account  account1{"Hassan Mugabo"};

Account  account2{"Mwanaisha Sulaiman"};

cout << account1.getAccountName() << endl;
cout << endl;
cout  << account2.getAccountName() << endl;

return 0;    
}