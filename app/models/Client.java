package models;

public class Client {

	private String name = null;
	private Long id = (long) -1;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public static Client findById(Long id) {
		Client client = new Client();
		client.setName("toto" + id);
		client.setId(id);
		return client;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", id=" + id + "]";
	}

	public void delete() {
		System.out.println("Client deleted");

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
