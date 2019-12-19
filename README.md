# Train Demo

Train Demo is a ...

## Vocab

These are terms used in this project. The following come from our Amtrak data.

1. __Agency__ - An agency is an organization that provides transportation services. Usually this is just Amtrak.

2. __Stop__ - A stop, also called a station, is a physical location where someone enters or exits a train or bus.

3. __Trip__ - A trip is an ordered set of stops, each with an arriving and departing time. A trip also has a *calendar* which details which days of the week a trip is active on.

4. __Route__ - A route represents the physical tracks a train runs on. A route has many trips. In most cases, each of a route's trips have the same stops, but there is no garentee of this. A route is operated by an agency.

To complete this application, you will have to introduce many new terms to describe concepts in your system. I suggest a few here.

5. __Connection__ - A connection connects two trips together at a specific stop. For example, to get from AAA to CCC, you may have to take a trip from AAA to BBB, then another from BBB to CCC. We would say you have a connection at BBB.

6. __Path__ - A path describes how a customer would actually get from stop A to B. So (at a minimum) a path would include a departure date and time, a set of trips, and a set of connections.

7. __Ticket__ - A ticket is what a customer uses to board the train. A customer may require many tickets if their path has many trips.

8. __Reservation__ - A reservation is what a customer actually pays for. It may include many tickets for many people.