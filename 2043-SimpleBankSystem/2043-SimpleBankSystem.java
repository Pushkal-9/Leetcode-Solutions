// Last updated: 18/04/2025, 22:34:07
class Bank {

    long[] accounts;
    int numberOfAccounts;
    public Bank(long[] balance) {

        numberOfAccounts = balance.length;
        accounts = new long[numberOfAccounts];


        for(int i=0;i<numberOfAccounts;i++){
            accounts[i]=balance[i];
        }

    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(numberOfAccounts<account1 || numberOfAccounts<account2){
            return false;
        }

        if(accounts[account1-1]<money){
            return false;
        }

        accounts[account1-1] = accounts[account1-1]-money;
        accounts[account2-1] = accounts[account2-1]+money;

        return true;
    }
    
    public boolean deposit(int account, long money) {
        if(numberOfAccounts<account){
            return false;
        }   

        accounts[account-1] = accounts[account-1] + money;    

        return true;
    }
    
    public boolean withdraw(int account, long money) {
        if(numberOfAccounts<account){
            return false;
        }

        if(accounts[account-1]<money){
            return false;
        }    

        accounts[account-1] = accounts[account-1]-money;

        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */