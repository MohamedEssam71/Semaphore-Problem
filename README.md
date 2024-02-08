# Synchronization Assignment

## Problem Definition:
The task is to simulate a limited number of devices connected to a router's Wi-Fi using Java threading and semaphore. The router should restrict the number of concurrent connections, allowing only a certain number of connections at any given time. Semaphore usage should be explained in controlling the concurrent connections.

### Rules:
- Initially, the Wi-Fi has no connected devices.
- When a client logs in and can be served, it performs connect, online activity, and logout actions with random waiting times.
- If all connections are occupied, a client must wait until a connection is released.
- After a client finishes, another waiting client can connect.

## Solution Design:
The program must comprise the following classes:
1. **Router Class**: Manages connections and methods for occupying and releasing connections.
2. **Semaphore Class**: Similar to the one used in the synchronization lab.
3. **Device Class**: Represents various devices (threads) that can connect to the router. Each device has a name and type and can perform connect, online activity, and disconnect actions.
4. **Network Class**: Contains the main method to prompt user inputs for maximum connections and total number of devices, along with details for each device.

## Program Output:
Output logs should be printed to a file, depicting the execution order of device threads and their respective messages.

### Sample Input:
What is the number of WI-FI Connections?  
2  
What is the number of devices Clients want to connect?  
4  
C1 mobile  
C2 tablet  
C3 pc  
C4 pc  

### Sample Output:
- (C1)(mobile) arrived
- (C2)(tablet) arrived
- Connection 1: C1 Occupied
- Connection 2: C2 Occupied
- C4(pc) arrived and waiting
- C3(pc) arrived and waiting
- Connection 1: C1 login
- Connection 1: C1 performs online activity
- Connection 2: C2 login
- Connection 2: C2 performs online activity
- Connection 1: C1 Logged out
- Connection 1: C4 Occupied
- Connection 1: C4 log in
- Connection 1: C4 performs online activity
- Connection 2: C2 Logged out
- Connection 2: C3 Occupied


(Note: This is an example scenario and not the only possible scenario.)
