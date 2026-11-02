/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repairjobscheduler;

/**
 *
 * @author ASUS EXPERTBOOK
 */
public class RepairQueue {
    private JobNode front;
    private JobNode rear;
    private int size;

    public RepairQueue() {
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        return front == null;
    }
        public void enqueue(RepairJob job) {
        JobNode node = new JobNode(job);
        if (isEmpty()) {
            front = node;
            rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;

}
            public RepairJob dequeue() {
        if (isEmpty()) {
            return null;
        }
        RepairJob job = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        size--;
        return job;
    }

                public int size() {
        return size;
    }

    /** Look at the front job without removing it. */
    public RepairJob peek() {
        return isEmpty() ? null : front.data;
    }
    public RepairJob searchById(String id) {
        JobNode current = front;
        while (current != null) {
            if (sameText(current.data.getJobId(), id)) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    /** Manual case-insensitive comparison (no built-in search helpers). */
    private boolean sameText(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            if (Character.toUpperCase(a.charAt(i)) != Character.toUpperCase(b.charAt(i))) {
                return false;
            }
        }
        return true;
    }


}