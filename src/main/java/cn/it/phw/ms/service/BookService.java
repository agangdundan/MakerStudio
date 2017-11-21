package cn.it.phw.ms.service;

import cn.it.phw.ms.pojo.User;
import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.pojo.Book;

import java.util.List;

public interface BookService extends BaseService {

    JsonResult doAddBook(Book book);

    JsonResult doUpdateBook(Book book);

    JsonResult doDeleteBook(Book book);

    JsonResult doDeleteBooks(List<Book> books);

    JsonResult findBookByAdmin(User user);

    JsonResult findBookByName(String name);

    JsonResult findBookByCategory(String category);

    JsonResult doBorrowBook();

    JsonResult doReturnBook();

}
