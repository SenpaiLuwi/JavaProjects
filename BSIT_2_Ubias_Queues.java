package Queues;
import java.util.Scanner;
public class queuesact {
    public int size, front, rear, temp;
    static Integer arrayQueue[];

	public static void main(String[] args) 
{
        Scanner sc = new Scanner(System.in);
        LinkedList l = new LinkedList();
        queuesact  a = null;
        int menu0 = 0;
        int mainmenu;
        int arraymenu;
        int linkedmenu;

        
//Menu for Implementation
        System.out.println("Menu");
        System.out.println("1. Array Implementation");
        System.out.println("2. Linked List Implementaion");
        System.out.print("\nEnter Choice: ");
        mainmenu = sc.nextInt();
        
        
//Array Implementation
        switch (mainmenu) 
        {
            case 1:
                System.out.print("\nEnter the size of the Queue: ");
                int n = sc.nextInt();
                a = new queuesact (n);
                
                do 
                {
                    System.out.println("\nMenu");
                    System.out.println("1. Enquence");
                    System.out.println("2. Dequence");
                    System.out.println("3. Display Queue");
                    System.out.println("4. Exit.");
                    System.out.print("\nEnter Choice: ");
                    arraymenu = sc.nextInt();

                    switch (arraymenu) 
                    {
                        case 1:
                            System.out.print("\nEnter Data to queue: ");
                            int item = sc.nextInt();
                            a.enqueue(item);
                            break;

                        case 2:
                            a.dequeue();
                            break;

                        case 3:
                            a.display();
                            break;

                        case 4:
                            {
                                System.out.println("Program Terminated. By Ubias, John Louie");
                                System.exit(0);
                                break;
                            }
                    }
                }
                while (menu0 == 0) ;
                break;
                
   
//Linked List Implementation
            case 2:
            	l = new LinkedList();
                boolean loop = true;

                do {
                    System.out.println("\nMenu");
                    System.out.println("1. Enqueue");
                    System.out.println("2. Dequeue");
                    System.out.println("3. Display Queue");
                    System.out.println("4. Exit.");
                    
                    System.out.print("\nEnter Choice: ");
                    linkedmenu = sc.nextInt();
                    if (linkedmenu == 4) 
                    {
                        loop = false;
                    }
                    switch (linkedmenu) 
                    {
                    //Enqueue of the user input
                        case 1:
                        	l.enqueue(sc);
                            break;

                     //Dequeue of the user input       
                        case 2:
                        	l.dequeue();
                            break;
                            
                      //Display of the user input   
                        case 3:
                            l.display();
                            break;
                            
                       //Termination     
                        case 4:
                        {
                                System.out.println("Program Terminated. By Ubias, John Louie");
                                System.exit(0);
                                break;
                            }
                    }
                }
                while (loop) ;
        }
    }

//Determine
    public queuesact ( int n)
    {
        size = n;
        front = -1;
        rear = -1;
        temp = 0;
        arrayQueue = new Integer[size];
    }

//Enqueue
    public void enqueue ( int item)
    {
        if (full())
            System.out.println("The Queue is Overflow");
        else if (rear == -1) 
        {
        	front = -1;
            rear = 0;
            arrayQueue[rear] = item;
        } 
        else
        {
        	rear++;
        	arrayQueue[rear] = item;

        }
    }

//Dequeue
    public int dequeue () 
        {
        if (empty()) {
            System.out.println("The Queue is Underflow");
            System.exit(-1);
        }

        front = front + 1;
    	int temp = arrayQueue[front];
    	if(front == rear) {
    		front = -1;
    		rear = -1;
    	}

    	else
    	{
    		arrayQueue[front] = null;
    	}
    	return temp;
    }
    
//Display
    public void display () 
    {
		if(front == rear) {
			front = -1;
			rear = -1;
		}
		
		System.out.print("\nQueue: ");
		
		for(int i=0; i < size; i++) {
			if(arrayQueue[i] != null)
				System.out.print(arrayQueue[i] + " | ");
		}
		
		System.out.println("\nFront: " + (front+1) + "\nRear: " + rear);
	}

    public int front () 
    {
        if (empty())
            System.out.println("The queue is empty ");
        return arrayQueue[front];
    }

    public int rear () 
    {
        if (empty())
            System.out.println("The queue is empty ");
        return arrayQueue[rear];
    }

    private boolean full () 
    {
        if ( rear == size -1)
            return true;
        return false;
    }

    private boolean empty () 
    {
        if (front == rear)
            return true;
        return false;
    }

//LinkedList
static class LinkedList 
    {
        Scanner sc = new Scanner(System.in);
        int front = -1;
        int rear = -1;
        int num = 5;
        int queue[] = new int[num];
        
//Enqueue
void enqueue(Scanner sc) 
        {
            if (rear == (num - 1))
            {
                System.out.print("Queue Overflow ");
                System.exit(0);
            }
            else 
            {


                System.out.print("\nEnter Data to queue: ");
                int i = this.sc.nextInt();
                if (front == -1 && rear == -1)
                {
                	front = 0;
                	rear = 0;
                	queue[rear] = i;
                } 
                else 
                {
                	rear = rear + 1;
                	queue[rear] = i;
                }
            }
        }

//Dequeue
        void dequeue()
        {
        	if(front==rear)
            {
                System.out.print("\nQueue Underflow");

            } 
            else 
            {
            	front = front + 1;
            }
        }

        
//Display
void display()
        {
            System.out.print("Queue ");
            for (int i = front; i <= rear; i++) 
            {
                System.out.print(queue[i] + " | ");
            }
        }


public int front() 
        {
            if (isEmpty())
                System.out.println("The queue is empty ");
            return queue[front];
        }

        public int rear() 
        {
            if (isEmpty())
                System.out.println("The queue is empty ");
            return queue[rear];
        }


        private boolean isEmpty() 
        {
            if (front == -1)
                return true;
            return false;
        }
    }
}



