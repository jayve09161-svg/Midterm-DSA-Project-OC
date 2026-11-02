/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repairjobscheduler;

/**
 *
 * @author ASUS EXPERTBOOK
 */

/**
 * Simple manual tests for RepairQueue (no JUnit, no built-in collections).
 * Run this file: it prints PASS or FAIL for each check.
 */
public class QueueTest {

    private static int failures = 0;

    private static void check(String name, boolean condition) {
        if (condition) {
            System.out.println("PASS: " + name);
        } else {
            System.out.println("FAIL: " + name);
            failures++;
        }
    }

    private static RepairJob job(String id) {
        return new RepairJob(id, "Test Customer", "09123456789", "Laptop", "No power");
    }

    public static void main(String[] args) {
        RepairQueue q = new RepairQueue();

        check("new queue is empty", q.isEmpty());
        check("dequeue on empty returns null", q.dequeue() == null);
        check("peek on empty returns null", q.peek() == null);

        q.enqueue(job("JOB-001"));
        q.enqueue(job("JOB-002"));
        q.enqueue(job("JOB-003"));
        check("size is 3 after three enqueues", q.size() == 3);
        check("peek shows the first job", q.peek().getJobId().equals("JOB-001"));

        check("search finds JOB-002", q.searchById("JOB-002") != null);
        check("search is case-insensitive", q.searchById("job-003") != null);
        check("search misses JOB-999", q.searchById("JOB-999") == null);
        check("position of JOB-003 is 3", q.positionOf("JOB-003") == 3);
        check("position of unknown job is -1", q.positionOf("JOB-999") == -1);

        check("dequeue returns JOB-001 first (FIFO)", q.dequeue().getJobId().equals("JOB-001"));
        check("dequeue returns JOB-002 second", q.dequeue().getJobId().equals("JOB-002"));
        check("size is 1 after two dequeues", q.size() == 1);
        check("processed job is no longer found", q.searchById("JOB-001") == null);

        q.dequeue();
        check("queue is empty again", q.isEmpty());
        q.enqueue(job("JOB-004"));
        check("queue works after becoming empty", q.peek().getJobId().equals("JOB-004"));

        System.out.println(failures == 0 ? "ALL TESTS PASSED" : failures + " TEST(S) FAILED");
    }
}
