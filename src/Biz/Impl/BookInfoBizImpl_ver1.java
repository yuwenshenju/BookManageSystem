package Biz.Impl;
import java.util.Map;
import Biz.BookInfoBiz;
import Util.FileUtil;
import entity.BookInfo;

/**
 * BookInfoBiz的第一个版本BookInfo实现类
 * @author DELL2017
 *创建时间:2020年6月4日 下午3:26:44
 */
public class BookInfoBizImpl_ver1 implements BookInfoBiz{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3900928059701481047L;
	@Override
	public boolean add(BookInfo bookinfo) {
		//1.得到所有的BookInfoMap
		//2.向集合中写入传入的BookInfo对象
		//3.将map重新写入文件
		if(bookinfo==null) return false;
		
		Map<String,BookInfo> bookinfoMap=findAll();
		if(bookinfoMap==null) return false;
		if(bookinfoMap.containsKey(bookinfo.getIsbn())) {
			//判断传入的图书信息是否重复
			return false;
		}
		bookinfoMap.put(bookinfo.getIsbn(), bookinfo);
		FileUtil.SavaBookInfoMap(bookinfoMap);
		return true;
	}

	@Override
	public boolean del(BookInfo bookinfo) {
		if(bookinfo==null) return false;
		
		Map<String,BookInfo> bookinfoMap=findAll();
		if(bookinfoMap==null) return false;
		if(!bookinfoMap.containsKey(bookinfo.getIsbn())) {
			return false;
		}
		bookinfoMap.remove(bookinfo.getIsbn());//从map删除
		FileUtil.SavaBookInfoMap(bookinfoMap);//再重新写入文件
		return false;
	}

	@Override
	public BookInfo update(BookInfo bookinfo) {
		if(bookinfo==null) return null;
		Map<String,BookInfo> bookinfoMap=findAll();
		if(bookinfoMap==null) return null;
		if(!bookinfoMap.containsKey(bookinfo.getIsbn())) {
			return null;
		}
		bookinfoMap.put(bookinfo.getIsbn(), bookinfo);
		FileUtil.SavaBookInfoMap(bookinfoMap);
		return null;
	}

	@Override
	public BookInfo findById(String id) {
		//不实现此方法，抛出此操作
		throw new UnsupportedOperationException("在BookInfoBiz类中不支持通过Id查询图书");
		
	}

	@Override
	public Map<String, BookInfo> findAll() {
	
		return FileUtil.ReadBookInfoMap();
	}

	@Override
	public boolean outStore(String isbn, int outCount) {
		//获得文件中所有的图书信息
		Map<String,BookInfo> bookinfoMap=findAll();
		if(bookinfoMap==null) return false;
		BookInfo bookinfo=bookInfoFindByIsbn(isbn);//得到图书信息
		if(bookinfo==null) return false;//没有找到该书籍
		if(outCount>bookinfo.getInStoreCount()) {//出库数量不能大于存储量
			return false;
		}
		//实现出库操作
		bookinfo.setInStoreCount(bookinfo.getInStoreCount()-outCount);
		//将更改过的信息放回集合
		bookinfoMap.put(isbn, bookinfo);
		//文件更新
		FileUtil.SavaBookInfoMap(bookinfoMap);
		return true;
	}

	@Override
	public boolean inStore(String isbn, int inCount) {
		//获得文件中所有的图书信息
				Map<String,BookInfo> bookinfoMap=findAll();
				if(bookinfoMap==null) return false;
				BookInfo bookinfo=bookInfoFindByIsbn(isbn);//得到图书信息
				if(bookinfo==null) return false;//没有找到该书籍
				bookinfo.setInStoreCount(bookinfo.getInStoreCount()+inCount);
				bookinfoMap.put(isbn, bookinfo);
				FileUtil.SavaBookInfoMap(bookinfoMap);
		return true;
	}

	@Override
	public BookInfo bookInfoFindByIsbn(String isbn) {
		if(isbn==null|| "".equals(isbn)) return null;
		Map<String,BookInfo> bookinfoMap=findAll();
		if(bookinfoMap==null) return null;
		if(!bookinfoMap.containsKey(isbn)) {
			return null;
		}
		return bookinfoMap.get(isbn);
	}

	

}
