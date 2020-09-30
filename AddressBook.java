import java.util.*;

public class AddressBook implements ManageAddressBook{
	static Scanner sc=new Scanner(System.in);
	static Map<String,AddressBook> nameToAddressBookMap=new HashMap<String,AddressBook>();
	public String name;
	public ArrayList<Contact> contacts;
	public Map<String,Contact> nameToContactMap;
	
	public AddressBook(String name) {
		super();
		this.name=name;
		this.contacts = new ArrayList<Contact>();
		this.nameToContactMap=new HashMap<String,Contact>();
	}
	
	public void addContact(Contact contact) {
		contacts.add(contact);
		nameToContactMap.put(contact.getFirstName()+" "+contact.getLastName(), contact);
	}
	
	public void editContact(String name,String address,String city,String state, int zip,long phoneNumber,String email) {
		nameToContactMap.get(name).setAddress(address);
		nameToContactMap.get(name).setCity(city);
		nameToContactMap.get(name).setState(state);
		nameToContactMap.get(name).setZip(zip);
		nameToContactMap.get(name).setPhoneNumber(phoneNumber);
		nameToContactMap.get(name).setEmail(email);
	}
	
	public void deleteContact(String name) {
		contacts.remove(nameToContactMap.get(name));
		nameToContactMap.remove(name);
	}
	

	@Override
	public String toString() {
		return "Address Book "+name+" with "+contacts.size()+(contacts.size()==1?" contact":" contacts");
	}
	public static void main(String[] args){	
		while(true) {
			System.out.println("1.Add an address book\n2.Exit\nEnter your choice: ");
			int choice=Integer.parseInt(sc.nextLine());
			if(choice==1) {
				System.out.println("Enter name of the address book");
				String name=sc.nextLine();
				nameToAddressBookMap.put(name,new AddressBook(name));
			}
			else if(choice==2) {
				break;
			}
			else {
				System.out.println("Invalid choice. Try again.");
			}
		}
		while(true) {
			System.out.println("Enter the name of the address book to continue or nothing to exit: ");
			AddressBook addressBook=nameToAddressBookMap.get(sc.nextLine());
			if(addressBook==null) {
				break;
			}
			while(true) {
				System.out.println("1.Add Contacts\n2.Edit a contact\n3.Delete a contact\n4.Exit\nEnter your choice: ");
				int choice=Integer.parseInt(sc.nextLine());
				if(choice==1) {
					while(true) {
						System.out.println("1.Add next Contact\n2.Exit\nEnter your choice: ");
						int choice1=Integer.parseInt(sc.nextLine());
						if(choice1==1) {
							System.out.println("Enter the fields in order: \nfirst_name\nlastname\naddress\ncity\nstate\nzip\nphone no.\nemail");
							addressBook.addContact(new Contact(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),Integer.parseInt(sc.nextLine()),Long.parseLong(sc.nextLine()),sc.nextLine()));
						}
						else if(choice1==2) {
							break;
						}
						else {
							System.out.println("Invalid Choice. Try Again.");
						}
					}
				}
				else if(choice==2) {
					System.out.println(addressBook);
					System.out.println("Before edit:");
					for(Contact contact: addressBook.contacts) {
						System.out.println(contact);
					}
					System.out.println("Enter name of person whose contact details are to be edited: ");
					String editName=sc.nextLine();
					System.out.println("Enter the new fields in order: address\ncity\nstate\nzip\nphone no.\nemail");
					addressBook.editContact(editName,sc.nextLine(),sc.nextLine(),sc.nextLine(),Integer.parseInt(sc.nextLine()),Long.parseLong(sc.nextLine()),sc.nextLine());		
					System.out.println("After Edit");
					for(Contact contact: addressBook.contacts) {
						System.out.println(contact);
					}					
				}
				else if(choice==3) {
					System.out.println("Enter the name of Contact person to be deleted: ");
					String deleteName=sc.nextLine();
					addressBook.deleteContact(deleteName);
					System.out.println("After Delete");
					System.out.println(addressBook);
					for(Contact contact: addressBook.contacts) {
						System.out.println(contact);
					}
				}
				else if(choice==4) {
					break;
				}
				else {
					System.out.println("Invalid choice. Try again.");
				}
			}			
			
		}
		sc.close();
		
	}

	
}
interface ManageAddressBook{
	public void addContact(Contact contact);
	public void editContact(String name,String address,String city,String state, int zip,long phoneNumber,String email);
	public void deleteContact(String name);
}
class Contact{
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private int zip;
	private long phoneNumber;
	private String email;
	public Contact(String firstName, String lastName, String address, String city, String state, int zip,
			long phoneNumber,String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email=email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZip() {
		return zip;
	}
	public void setZip(int zip) {
		this.zip = zip;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Contact: "+firstName +" "+ lastName+ ", "+address+", "+city+", " +state+ ", "+zip+", "+ phoneNumber + "\n"+email+".";
	}
	
}
