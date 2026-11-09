# Computer Repair Job Scheduler

IT20: Data Structures and Algorithms | Midterm Mini-Project | S.Y. 2026-2027
Institute for Computer Studies

A Java Swing desktop application for a computer repair shop. It registers repair jobs, shows the pending jobs, processes the next repair, and searches a job by its ID. The jobs are stored in a **queue (first in, first out) that we coded by hand from a singly linked list**. No `java.util` classes, Java Collections or built-in search functions are used.

## Features

1. **Register a repair job.** Enter the customer name, contact number, device and issue. The app creates a job ID automatically (`JOB-001`, `JOB-002`, ...) and adds the job to the back of the queue.
2. **Display pending jobs.** The list shows every waiting job in processing order, and a line above it shows the next repair and how many jobs are pending.
3. **Process the next repair.** Removes the job at the front of the queue and shows its details.
4. **Search by job ID.** A manual linear search through the stored jobs. The status bar shows **FOUND** (with the job and its queue position) or **NOT FOUND**. The search is not case-sensitive, so `job-002` finds `JOB-002`.

### Input validation

- Customer name, device and issue cannot be empty.
- The contact number must be 7 to 11 digits (numbers only).
- The search box cannot be empty.
- Errors appear in red in the status bar, and nothing is added to the queue.

## Data structure

The app uses a **queue** built from a **singly linked list**. Repairs are handled in the order they arrive, so the first job registered is the first job repaired.

```
front                                   rear
  |                                       |
  v                                       v
[JOB-001] -> [JOB-002] -> [JOB-003] -> null
 next to be repaired                  newest job
```

| Operation | What it does | Time |
|---|---|---|
| `enqueue(job)` | Adds a job at the rear (Register Job) | O(1) |
| `dequeue()` | Removes and returns the front job (Process Next Repair) | O(1) |
| `peek()` | Shows the front job without removing it | O(1) |
| `isEmpty()`, `size()` | Tell whether jobs are waiting and how many | O(1) |
| `searchById(id)` | Manual linear search by job ID (Search) | O(n) |
| `positionOf(id)` | Position in the line, or -1 if not found | O(n) |
| `toDisplayString()` | Builds the text for the pending list | O(n) |

**Why linear search?** A linked list has no index, so binary search cannot jump to the middle. The search walks the real stored nodes from the front and does not read the text shown on the screen.

## Project structure

```
RepairJobScheduler/
  src/repairjobscheduler/
    RepairJob.java           record of one repair job
    JobNode.java             one node of the linked list
    RepairQueue.java         the queue and the manual search
    RepairSchedulerGUI.java  Swing window (with RepairSchedulerGUI.form)
  nbproject/, build.xml      NetBeans project files
```

## Setup and how to run

**Requirements:** Apache NetBeans and a JDK. We developed it with NetBeans and JDK 26. Use the same or a newer JDK, because an older one can show "Invalid Java Platform Version".

1. Clone the repository:

   ```
   git clone https://github.com/jayve09161-svg/Midterm-DSA-Project-OC.git
   ```

   Clone it to a folder outside OneDrive, for example `C:\Projects`.
2. Open NetBeans and choose **File > Open Project**.
3. Select the `RepairJobScheduler` folder inside the clone and click **Open Project**.
4. If NetBeans shows **Project Problems**, click **Resolve Problems...** and choose your JDK.
5. Right-click `RepairSchedulerGUI.java` and choose **Run File** (Shift+F6).

## How to use the app

1. Fill in the four fields on the left and click **Register Job**. The job appears in the pending list.
2. Register a few jobs. They are numbered `JOB-001`, `JOB-002`, `JOB-003`.
3. Type a job ID in the search box (for example `JOB-002`) and click **Search**.
4. Click **Process Next Repair**. The oldest job leaves the queue, and a window shows its details.
5. Search for the processed job again. It now says **NOT FOUND**, because it is no longer in the queue.

## Testing

We tested the queue and the window by hand:

- Registering with an empty name, device or issue shows an error.
- A contact number with letters, or with fewer than 7 digits, shows an error.
- Three valid jobs become `JOB-001`, `JOB-002` and `JOB-003`.
- Search finds an existing ID (in any letter case) and says NOT FOUND for an unknown ID.
- Process Next Repair removes `JOB-001` first (first in, first out).
- Searching for a processed job says NOT FOUND.
- Processing an empty queue shows a message and does not crash.

## Limitations

- Data is kept in memory only, so all jobs are lost when the app is closed.
- Job numbers start again at `JOB-001` each time the app opens.
- Processed jobs are not kept, so they cannot be searched afterwards.

## Team and roles

| Member | GitHub | Main work |
|---|---|---|
| Jaybee  | [@jayve09161-svg](https://github.com/jayve09161-svg) | Repository setup, `RepairJob`, `JobNode`, `RepairQueue` (queue operations and search) |
| Shaira Operio | [@operioshaira90-sketch](https://github.com/operioshaira90-sketch) | `RepairSchedulerGUI` (window, validation, button handling) |

We worked on separate branches, committed in small steps, and reviewed and merged each other's pull requests on GitHub.

## Repository

https://github.com/jayve09161-svg/Midterm-DSA-Project-OC
