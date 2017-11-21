package cn.it.pwh.ms.service;

import cn.it.pwh.ms.common.JsonResult;
import cn.it.pwh.ms.pojo.Book;
import cn.it.pwh.ms.pojo.User;

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
