# Use Cases

These use cases outline how users will perform tasks on your website. You will have to implement many features to satisfy them.

1. User signs in with their chosen OAuth2 provider. Examples include Google, Twitter, Facebook, etc.

2. User edits billilng address.
    1. User selects an existing billing address or selects to create a new one.
    2. User enters or updates all fields of their billing address.
    3. System responds with a success or failure depending on if (1) user completed all required fields, and (2) the fields make a valid address.

3. User edits payment information.
    1. User selects an existing payment method or selects to create a new one.
    2. User enters or updates all relevent fields pertaining to credit card info.
    3. User selects a billing address or creates a new one.
    4. System responds with success or failure depending on if they entered a valid card.

4. User views past purchases.
    1. User requests to see past purchases.
    2. User may request to see more details for a purchase.
    3. User can view and print reciets and tickets of purchases.

4. User views a list of all available stations that includes what routes serve them. 

5. User shares location.
    1. System prompts user to share location. (Most likely using the browser's Geolocation API.)
    2. User accepts or declines.
    3. If the user accepts, the system will remember their location and suggest nearby stations during relevent dialogs.

6. User purchases ticket(s).
    1. User enters their desired destination, source, and a departing date.
    2. System responds with a list of paths that satisfy the user's request. Each path includes all constituting details such as stops, trips, connections, dates, times and total path time.
    3. User selects their desired path along with the class of seat (coach, buisness, etc) they want for each leg (trip) of their journy.
    4. User also enters how many passengers of each type (adult, child, infant, etc) and any relevent discounts (student, vetern, senior, etc).
    5. User also enters if they are checking any bicycles and if so how many.
    6. System responds with a itemized list of their journy with costs on each item.
    7. User selects (1) to pay with saved payment info, (2) to pay with a new payment info, or (3) pay with PayPal.
        1. System may prompt user to sign in to save or access payment info. User may check out "as a guest" or pay with PayPal without signing in.
    8. User confirms purchase.
    9. System responds with (1) receipt and (2) purchased ticket(s).
    10. System also emails receipt and tickets to user.