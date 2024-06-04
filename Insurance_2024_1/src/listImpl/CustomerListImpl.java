package listImpl;
import java.util.ArrayList;
import IF.CustomerList;
import domain.Customer;
public class CustomerListImpl implements CustomerList {
	private ArrayList<Customer> customerList;
	private String DBAccesskey;
	public Customer m_Customer;
	public ArrayList<Customer> retrieveAll(){
		return customerList;
	}
	public CustomerListImpl(){
		customerList = new ArrayList<>();
	}
	public void finalize() throws Throwable {

	}
	public String add(Customer Customer){
		for (Customer customer : customerList) {
			if (customer.getCustomerID() == Customer.getCustomerID()) {
				return "[error] id가 중복되었습니다. 다시 시도해주세요";
			}
		}
		this.customerList.add(Customer);
		return "[success] 새로운 고객정보가 등록되었습니다.";
	}
	public String deleteById(int id){
		Customer deleteCustomer = null;
		for (Customer customer : customerList) {
			if (customer.getCustomerID() == id) {
				deleteCustomer = customer;
			}
		}
		if (deleteCustomer==null) {
			return "[error] 해당 id의 고객정보가 존재하기 않습니다.";
		}
		customerList.remove(deleteCustomer);
		return "[success] 해당 고객정보가 삭제되었습니다.";
	}
	public Customer retrieveById(int id){
		for (Customer customer : customerList) {
			if (customer.getCustomerID() == id) return customer;
		}
		return null;
	}
	public void update(int id, Customer Customer){

	}
}