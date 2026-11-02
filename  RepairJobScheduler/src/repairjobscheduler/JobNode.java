/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repairjobscheduler;

/**
 *
 * @author ASUS EXPERTBOOK
 */
public class JobNode {
    RepairJob data;
    JobNode next;

    public JobNode(RepairJob data) {
        this.data = data;
        this.next = null;
    }
}

