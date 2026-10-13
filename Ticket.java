package ticket;

import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;

public class Ticket {

    static class Tickets{
        String name;
        int urgency;
        int arrivalOrder;
        
        Tickets(String name, int urgency, int arrivalOrder){
            this.name = name;
            this.urgency = urgency;
            this.arrivalOrder = arrivalOrder;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        PriorityQueue<Tickets> queue = new PriorityQueue<>(
          Comparator.comparingInt((Tickets t) -> t.urgency).thenComparing(t -> t.arrivalOrder)
        );
        
        System.out.print("Enter number of Tickets: ");
        int n = sc.nextInt();
        sc.nextLine();
        
        for(int i = 1; i <= n; i++){
            System.out.print("Enter ticket name: ");
            String name = sc.nextLine();
            System.out.print("Enter urgency number: ");
            int urgency = sc.nextInt();
            sc.nextLine();
            
            queue.offer(new Tickets(name, urgency, i));
        }
        
        System.out.println("\nTicket Processing Order:");
        
        while(!queue.isEmpty()){
            Tickets ticket = queue.poll();
            
            System.out.println(ticket.name + "(Urgency: " + ticket.urgency + ")");
        }
        sc.close();
    }
    
}
