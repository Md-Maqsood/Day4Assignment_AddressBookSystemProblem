import java.util.*;
public class AddressBook{
	static Scanner sc=new Scanner(System.in); 
	public Contact[] contacts;
	public int numOfContacts;
	public AddressBook() {
		super();
		contacts = new Contact[5];
		numOfContacts=0;
	}
	public void addContact(String firstName,String lastName,String address,String city,String state, int zip,long phoneNumber,String email) {
		contacts[numOfContacts]=new Contact(firstName, lastName, address, city, state, zip, phoneNumber, email);
		numOfContacts++;
	}
	
	public static void main(String[] args) {
		AddressBook addressBook=new AddressBook();
		System.out.println("Enter the fields in order: \nfirst_name\nlast_name\naddress\ncity\nstate\nzip\nphone no.\nemail");
		addressBook.addContact(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine(),Integer.parseInt(sc.nextLine()),Long.parseLong(sc.nextLine()),sc.nextLine());
		for(Contact contact:addressBook.contacts) {
			if(contact==null) {
				continue;
			}
			System.out.println(contact);
		}
	}	
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
		return "Contact: "+firstName + " "+ lastName+ ", "+address+", "+city+", " +state+ ", "+", " +zip+ ", "+ phoneNumber + "\n"+email+".";
	}
	
}