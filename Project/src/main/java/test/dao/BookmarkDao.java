package test.dao;

import java.util.List;
import java.util.Map;

import test.vo.Bookmark;

public interface BookmarkDao {
	int insert(Bookmark bookmark) throws Exception;
	int delete(Bookmark bookmark) throws Exception;
	List<Bookmark> viewMyBookmarkList(Map<String,Object> paramMap) throws Exception;
}
