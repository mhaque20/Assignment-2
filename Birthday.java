import javax.swing.JOptionPane;
import java.util.Random;
import java.text.NumberFormat;

public class Birthday {
	public static void main (String[] args) {
		String name;
		String input;
		int age;
		String toyChoice;
		String card;
		String balloon;
		String anotherToy = "Yes";
		double totalCost = 0;
		int orderNum;
		String choice = "Yes";
		
		NumberFormat fmt1 = NumberFormat.getCurrencyInstance();
		
		
		Random order = new Random();
		orderNum = order.nextInt(100000);
		
		//Display the welcome message.
		JOptionPane.showMessageDialog(null," Welcome to the Toy Company \n"+ "to choose gifts for young children");
		
		while(anotherToy.equals("Yes")||anotherToy.equals("yes"))
		{
			while(choice.equals("Yes")||choice.equals("yes"))
			{
				//Ask the user the name of the child.
				name = JOptionPane.showInputDialog("Enter the name of the child");
				
				//Ask the age of the child.
				input = JOptionPane.showInputDialog("How old is the child ");
				age = Integer.parseInt(input);
				
				Toy mToy = new Toy();
				mToy.setAge(age);
				
				//Ask for the toy choice.
				toyChoice = JOptionPane.showInputDialog("Choose a toy: a plushie, blocks, or a book");
				mToy.setToy(toyChoice);
				
				if(!mToy.ageOK())
				{
					//Display a message if the toy is not age appropriate.
					choice = JOptionPane.showInputDialog("the toy is not age appropriate. Do you want to cancel that toy request? Yes or No");
					
				}
				
				if (mToy.ageOK()||choice.equals("no"))
				{
                    mToy = new Toy(toyChoice,age);
					
                    //Ask if a card or balloon should be added to the gift.
					card = JOptionPane.showInputDialog("Do you want a card with the gift? Yes or No");
					mToy.addCard(card);
					
					balloon = JOptionPane.showInputDialog("Do you want a balloon with the gift? Yes or No");
					mToy.addBalloon(balloon);
					
					Toy display = new Toy(toyChoice,age);
					totalCost += (mToy.getCost());
					System.out.println("The gift for "+ name + display.toString());
					
					//Ask if another gift is desired
					anotherToy = JOptionPane.showInputDialog("Do you want another toy? Yes or No");
					
					if(anotherToy.equals("no"))
					{
						break;
					}
				}
				
					
				
			}
			    //display the total amount of the order, a random five- digit order number.
				System.out.print("The total cost of your order is "+fmt1.format(totalCost));
				System.out.println(" Order number is " + orderNum);
				
				//Display programmer name. 
				System.out.println("Programmer : Mahdia Haque");
			
		}
		
		
		
		
	}

}
