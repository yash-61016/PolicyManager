# PolicyManager🎫
A simple insurance premium calculator prototype to demonstrate key features.

The basic insurance premium is calculated based on the number of gadgets and
the value of the most expensive item as listed in the Monthly Premiums table below.
### Preview
<img width="427" alt="Screenshot 2021-08-24 at 17 09 30" src="https://user-images.githubusercontent.com/73232849/130655293-ab2a5fd3-9bcd-4ca8-ac63-58c0bffe3050.png">

Basic Monthly Premiums:-
|`Number of Items`|`Maximum Value of Most Expensive Gadget`|	
| --- | --- |
|	 |£500\|£800\|£1,000|
|1|5.99	\|7.15\|8.30|
|2 - 3|10.99\|13.35\|15.55|
|4 - 5 |15.99\|19.60\|22.82|

 Example Data:-
|`Number of Items` |`Most Expensive Item`	|`Monthly Premium`|
|---|---|---|
|2|£600|£13.35|
|4|£200|£15.99|
|6|£800|Reject|
|4|£1,200|Reject|

## How program works
The company charges an excess (the amount the client will have to pay) of £30 for each claim.

Clients can choose to increase this up to £70.00 (in multiples of 10) 
to reduce the premium – for each £10 increase the premium is reduced by 5%.

The default payment term is monthly. 
However, customers can choose to pay annually to receive an additional 10% discount.

As well as entering the inputs identified above, the user will also provide the following:
-Policy reference number (eg: JB123A – two letters, three digits and a letter).
-Client name (eg: J Smith – maximum of 20 characters)

### 1. Option 1 (Create New Policy):
* This option asks you necessary questions to create a new policy :

<img width="384" alt="Screenshot 2021-08-24 at 17 11 28" src="https://user-images.githubusercontent.com/73232849/130655589-5374f21c-8f31-48c8-97db-832f8ed473b2.png">

* And then it displays you a ticket with your intrest calculated :

 <img width="380" alt="Screenshot 2021-08-24 at 17 11 45" src="https://user-images.githubusercontent.com/73232849/130655758-66e4e721-4150-417e-8376-5f60844fdbfe.png">

### 2. Display Summary of Policies
* User is asked to select the current (policy.txt) or archive (archive.txt) policies and a summary of the following is displayed:
        * Total number of policies (accepted and rejected).
        *	Average number of items for the accepted policies.
        *	Average monthly premium for the accepted policies.
        *	Total number of policies per month. 
        *	
<img width="764" alt="Screenshot 2021-08-24 at 17 12 52" src="https://user-images.githubusercontent.com/73232849/130685932-1a47cef6-f102-44f4-af99-0f3a8d9db17d.png">

### 3. Display Summary of Policies for Selected Month
* The user is asked to select the current or archive policies and to enter a month.  A summary of policies (as specified in option 2 should then be displayed for the specified month).

<img width="766" alt="Screenshot 2021-08-24 at 17 13 34" src="https://user-images.githubusercontent.com/73232849/130686258-98f4a4d3-84d1-40bf-93cc-2fcbd94611c6.png">


### 4. Find and Display Policy
* The user is asked to select the current or archive policies and enter the search text.  The selected file should be searched for any matches (full or partial) against the reference or client name. 
<img width="766" alt="Screenshot 2021-08-24 at 17 14 33" src="https://user-images.githubusercontent.com/73232849/130686326-44d9aac3-6668-4cff-afb6-17088c67908c.png">
