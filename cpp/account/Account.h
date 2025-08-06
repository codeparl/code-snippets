/**
 *  THIS IS A SIMPLE C++ CLASS REPRESENTING A BANK ACCOUNT
 * AUTHOR: HASSAN MUGABO 
 * email: cybarox@gmail.com 
 * 
 */
#include <string>

//begin class Account declaration
class Account {

    //mark the constructor and methods public 
     public:
    //since our constructor has only one parameter, use explicit
    explicit Account(std::string name): accountName{name}{

    }  

   
    //a setter method to set a new account name
    void setAccountName(std::string name){
        this->accountName =  name;
    }

    //a getter method to give us the account name
    std::string getAccountName() const{
        return this->accountName;
    }

    //mark private members 
    private:
    std::string accountName;
    
}; //class declaration 