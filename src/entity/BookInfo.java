package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * ��ͼ��Isbn(�����)Ϊ��ʶ��ͼ����Ϣ
 * ÿһ��Isbn��Ӧһ��ͼ�����
 * @author DELL2017
 *����ʱ��:2020��6��2�� ����5:02:38
 *
 */
public class BookInfo implements Serializable{//���л��ӿ�
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String isbn;    //�����
	private String type; //ͼ������
	private String author;//����
	private String publisher;//������
	private int inStoreCount ; //������
	private Date publishDate;//����ʱ��
	private double price;//����
	
	//һ��bookinfo�����Ӧ���book����
	private List<Book> booklist;
	
	
	
	//������дequals,toString����
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getInStoreCount() {
		return inStoreCount;
	}
	public void setInStoreCount(int inStoreCount) {
		this.inStoreCount = inStoreCount;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}