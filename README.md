# myOfferService

Offers Management System
Let's design an Offers Engine (Q_E).for a credit card. Offers Engine is responsible for lifecycle ·, management of offers.
An offer should be defined

For admln and Internal users:
• Define offers and their details. Offer details would Include name of offer, and further details of offers to be used for computing and giving offers to users.
• E~ nd disable offers for a set of users by giving an offer and a list of users. Offers can be enabled for a set of users. One user can have multiple offers active for them.

For customer.
• Transactions are processed by the Transaction Processing System, and sent to OE immediately after that. OE should check what all offers are applicable to customers and apply those.
• Offer should apply automatically as soon as a transaction Is done by the user or a milestone is reached.
• In case multiple offers can be applied, apply the one with the highest outcome value for the user. If RewardPoints and Cashbacks both are possible, prefer Cashback.

Example offers:
Rat Rs 100 cashback on all transactions over Rs 500 on Swiggy
4 Reward Points for every Rs 100 spent anywhere (except on RentPayments)
Get a Flat Rs 500 cashback for spending Rs 10000 in a month
2% Cashback up to max Rs 500 for all transactions done at petrol pumps
Zara offer- For spend of Rs 100-500, get Rs 10 cashback: For 501-1000 => Rs 50 CB; For 1001-inflnite => Rs 100 CB


Potential Extensions (Optional)
• Get a Rs 500 Amazon voucher for spending Rs 10000 in a month (OptionaQ
• Probabilistic rewards - eg. get up to Rs 100 cashback on a Zomato transaction. 50%
users should get between 1-10; 25% users should get between 11-25; and so on
• Limit usage of an offer; for example- Flat Rs 100 cashback on all transactions over Rs
500 on Swiggy. (Up to a maximum Rs 500 per day; and Rs 2500 per month)
