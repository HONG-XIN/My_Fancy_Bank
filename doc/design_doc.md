### Specification

> #### Customer
>
> - Each customer can have multiple accounts.
> - Each account only support one currency.
> - For each customer, accounts can have same type and same currency.
> - If one saving account has more than X money, this customer can has one choice to open a security trading account binding to this saving account.
>   - security trading account only store how many stocks this customer has bought.
>   - The money for buy or the benefit of selling both go into the binding saving account.
>   - When the customer has chosen to sell the saving account, the security trading account automatically sell all its stocks and close.
>   - When a customer buy or sell stocks, for each time, the bank will take some fee.
>
> #### Manager
>
> - There is only one manager.
> - The manager is able to change all stocks' buy price and sell price.