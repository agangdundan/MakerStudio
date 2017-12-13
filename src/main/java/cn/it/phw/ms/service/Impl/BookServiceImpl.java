package cn.it.phw.ms.service.Impl;

import cn.it.phw.ms.common.AppContext;
import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.dao.mapper.BookMapper;
import cn.it.phw.ms.pojo.Book;
import cn.it.phw.ms.pojo.User;
import cn.it.phw.ms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl extends BaseServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public JsonResult doAddBook(Book book) {
        book.setCreateTime(new Date(System.currentTimeMillis()));
        //设置添加的管理员
        //...

        bookMapper.insert(book);
        jsonResult.setStatus(200);
        jsonResult.setMessage("添加完成");
        return jsonResult;
    }

    @Override
    public JsonResult doUpdateBook(Book book) {

        Book oldBook = bookMapper.selectByPrimaryKey(book.getId());
        if (oldBook == null) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("图书不存在");
        } else {
            if (book.getAdminId() != null) {
                oldBook.setAdminId(book.getAdminId());
            }
            if (book.getAdminName() != null) {
                oldBook.setAdminName(book.getAdminName());
            }
            if (book.getAuthor() != null) {
                oldBook.setAuthor(book.getAuthor());
            }
            if (book.getBookName() != null) {
                oldBook.setBookName(book.getBookName());
            }
            if (book.getCategory() != null) {
                oldBook.setCategory(book.getCategory());
            }
            if (book.getCreateTime() != null) {
                oldBook.setCreateTime(book.getCreateTime());
            }
            if (book.getImage() != null) {
                oldBook.setImage(book.getImage());
            }
            if (book.getPublish() != null) {
                oldBook.setPublish(book.getPublish());
            }
            if (book.getStatus() != null) {
                oldBook.setStatus(book.getStatus());
            }
            bookMapper.updateByPrimaryKey(oldBook);
            jsonResult.setStatus(200);
            jsonResult.setMessage("更新完成");
        }

        return jsonResult;
    }

    @Override
    public JsonResult doDeleteBook(Integer id) {
        if (id == null) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("参数错误");
        } else {
            bookMapper.deleteByPrimaryKey(id);
            jsonResult.setStatus(200);
            jsonResult.setMessage("删除完成");
        }

        return jsonResult;
    }

    @Override
    public JsonResult doDeleteBooks(List<Book> books) {
        return null;
    }

    @Override
    public JsonResult findBookByAdmin(User user) {
        return null;
    }

    @Override
    public JsonResult findBookByName(String name) {
        return null;
    }

    @Override
    public JsonResult findBookByCategory(String category) {
        return null;
    }

    @Override
    public JsonResult doBorrowBook() {
        return null;
    }

    @Override
    public JsonResult doReturnBook() {
        return null;
    }

    @Override
    public JsonResult findAllBooks() {
        List<Book> books = bookMapper.selectByExample(null);
        if (books.size() == 0) {
            jsonResult.setStatus(500);
            jsonResult.setMessage("未找到任何书籍");
        } else {
            jsonResult.setStatus(200);
            jsonResult.setMessage("加载完成");
            jsonResult.setCount(data.size());
            data.put(AppContext.KEY_DATA, books);
            jsonResult.setData(data);
        }
        return jsonResult;
    }

}
