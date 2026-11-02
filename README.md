# Midterm-DSA-Project-OC



\# Repair Job Scheduler



A Java Swing desktop app for a computer repair shop. It manages repair jobs with a manually coded linked-list queue, so jobs are processed first come, first served. Built for the IT20 Data Structures and Algorithms midterm mini-project (S.Y. 2026-2027).



\## Client scenario



A repair shop needs a simple tool to register incoming repair jobs, see who is waiting, work on the next job in line, and look up a job by its ID. The app keeps all records in memory, with no database or network.



\## Features



\- \*\*Register a job:\*\* enter the customer name, contact number, device and issue. Each job gets an automatic ID (`JOB-001`, `JOB-002`, and so on).

\- \*\*Input validation:\*\* name, device and issue are required, and the contact number must be 7 to 11 digits (numbers only). Errors show in red in the status bar.

\- \*\*Display pending jobs:\*\* the middle panel lists every waiting job in queue order, and a bold line shows who is next and how many are waiting.

\- \*\*Process the next repair:\*\* removes the job at the front of the queue and shows its details in a pop-up. Processing an empty queue shows an error message.

\- \*\*Search by Job ID:\*\* looks through the stored jobs and shows a green FOUND message with the job's details and queue position, or a red NOT FOUND message. Search is not case sensitive (`job-002` finds `JOB-002`).



\## Data structure and algorithm



\- \*\*Structure:\*\* a queue (first in, first out) built from linked `JobNode` objects, implemented in `RepairQueue.java` with `enqueue`, `dequeue`, `peek`, `isEmpty` and `size`.

\- \*\*Search:\*\* a manual linear search (`searchById`) that walks the nodes one by one, so it takes O(n) time. Binary search doesn't fit a linked list, because a linked list has no direct access to the middle node.

\- \*\*No Java Collections:\*\* the queue and the search are written by hand, without `ArrayList`, `LinkedList` or built-in search functions.



\## Project structure



```

Midterm-DSA-Project-OC/

&#x20; README.md

&#x20; RepairJobScheduler/

&#x20;   src/repairjobscheduler/

&#x20;     RepairJob.java           job record (ID, customer, contact, device, issue)

&#x20;     JobNode.java             one node in the linked queue

&#x20;     RepairQueue.java         queue operations and manual search

&#x20;     RepairSchedulerGUI.java  Swing window (form, list, status bar)

&#x20;     QueueTest.java           checks for the queue operations

```



\## Setup and how to run



1\. Install a JDK and Apache NetBeans (we used JDK \[26] and NetBeans \[31]).

2\. Clone the repository:

&#x20;  ```

&#x20;  git clone https://github.com/jayve09161-svg/Midterm-DSA-Project-OC.git

&#x20;  ```

3\. In NetBeans, choose \*\*File > Open Project\*\* and select the `RepairJobScheduler` folder.

4\. Expand \*\*Source Packages > repairjobscheduler\*\*, right-click `RepairSchedulerGUI.java`, and choose \*\*Run File\*\*.

5\. To run the queue tests, right-click `QueueTest.java` and choose \*\*Run File\*\*.



\## How to use



1\. Fill in the four boxes on the left and click \*\*Register Job\*\*.

2\. Watch the job appear in the Pending Jobs list.

3\. Click \*\*Process Next Repair\*\* to work on the job at the front of the queue.

4\. Type a Job ID (for example `JOB-001`) in the search box and click \*\*Search\*\*.



## Team and roles

| Member | GitHub | Main responsibility |
|---|---|---|
| Partner A: [Jaybee] | jayve09161-svg | Data structure and search |
| Partner B: [Shaira Operio] | operioshaira90-sketch | GUI and documentation |

### Partner A: data structure and search

- Wrote `RepairJob` (the job record) and `JobNode` (one node of the linked queue).
- Implemented `RepairQueue` from scratch with `enqueue`, `dequeue` (with an empty check), `peek`, `isEmpty` and `size`.
- Wrote the manual linear search `searchById`, the `positionOf` method, and `toDisplayString` for the pending list.
- Wrote `QueueTest` to check the queue operations.
- Pull requests: `feature/job-record-and-node`, `feature/queue-operations`, `feature/search-and-tests`.
- Commits: [number].

### Partner B: GUI and documentation

- Built the Swing window `RepairSchedulerGUI` in NetBeans: the registration form, the pending jobs panel and the status bar.
- Wrote the job ID generator (`JOB-001`, `JOB-002`, ...) and the input validation (required fields, contact number of 7 to 11 digits).
- Connected the Register Job, Process Next Repair and Search buttons to the queue, with green and red status messages and a FOUND / NOT FOUND result.
- Removed the NetBeans-generated `java.util` logger so the code follows the project rule of not using `java.util`.
- Wrote this README.
- Pull requests: `feature/gui-layout`, `feature/gui-operations`, `feature/gui-search-and-docs`.
- Commits: [number].

### How we worked together

- **Split by file:** each of us owned separate files, so we rarely edited the same file and avoided merge conflicts.
- **Feature branches:** every piece of work was done on its own branch and merged into `main` through a pull request.
- **Peer review:** Partner A reviewed and merged Partner B's pull requests, and Partner B reviewed and merged Partner A's. We read the **Files changed** tab before approving.
- **Order of work:** the GUI depends on the queue classes, so the queue was merged into `main` first, then the GUI buttons were connected to it.
- **Shared understanding:** we both traced the program by hand (register three jobs, process one, search) and can explain all five source files, not only our own.


\## Repository



https://github.com/jayve09161-svg/Midterm-DSA-Project-OC

