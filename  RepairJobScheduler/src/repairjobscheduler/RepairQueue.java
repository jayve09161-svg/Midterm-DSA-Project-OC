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
}
