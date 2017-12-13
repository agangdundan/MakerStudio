package cn.it.phw.ms.controller;

import cn.it.phw.ms.common.JsonResult;
import cn.it.phw.ms.pojo.Book;
import cn.it.phw.ms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ms")
public class BookController extends BaseController {

    @Autowired
    private BookService bookService;

    @ResponseBody
    @GetMapping("/books")
    public JsonResult findAllBooks() {
        return bookService.findAllBooks();
    }

    @ResponseBody
    @PostMapping("/book")
    public JsonResult updateBookByPK(Book book) {
        return bookService.doUpdateBook(book);
    }

    @ResponseBody
    @PutMapping("/book")
    public JsonResult addBook(Book book) {
        return bookService.doAddBook(book);
    }

    @ResponseBody
    @DeleteMapping("/book/{id}")
    public JsonResult deleteBookByPK(@PathVariable("id") Integer id) {
        return bookService.doDeleteBook(id);
    }

}
