# PolicyManager🎫
A simple insurance premium calculator prototype to demonstrate key features.

The basic insurance premium is calculated based on the number of gadgets and
the value of the most expensive item as listed in the Monthly Premiums table below.

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

The company charges an excess (the amount the client will have to pay) of £30 for each claim.
Clients can choose to increase this up to £70.00 (in multiples of 10) 
to reduce the premium – for each £10 increase the premium is reduced by 5%.
The default payment term is monthly. 
However, customers can choose to pay annually to receive an additional 10% discount.
