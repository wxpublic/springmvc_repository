package zttc.itat.web;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import zttc.itat.model.User;
import zttc.itat.service.IUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

/**
 * @version 1.0
 * @Description:
 * @author: ChenRuiQing.
 * Create Time:  2018-12-09 下午 9:47
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = {"/users"},method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("pagers",userService.find());
        return "user/list";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add(Model model){
        model.addAttribute(new User());
        return "user/add";
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String add(@Validated User user, BindingResult bindingResult, @RequestParam("attach") MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        if(bindingResult.hasErrors()){
            return "user/add";
        }
        String realPath = request.getServletContext().getRealPath("/accessozrykit");
        File file = new File(realPath+File.separator+multipartFile.getOriginalFilename());
        FileUtils.copyInputStreamToFile(multipartFile.getInputStream(),file);
        System.out.println(file.getPath());
        user.setAttachs(multipartFile.getOriginalFilename());
        userService.add(user);
        return "redirect:/user/users";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String show(@PathVariable int id,Model model){
        model.addAttribute(userService.load(id));
        return "user/show";
    }

    @RequestMapping(value = "/{id}/update",method = RequestMethod.GET)
    public String update(@PathVariable int id, Model model){
        model.addAttribute(userService.load(id));
        return "user/update";
    }

    @RequestMapping(value = "/{id}/update",method = RequestMethod.POST)
    public String update(@PathVariable int id, @Validated User user, BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            return "user/update";
        }
        userService.update(user);
        model.addAttribute(user);
        return "user/show";
    }

    @RequestMapping(value = "/{id}/delete",method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        userService.delete(id);
        return "redirect:/user/users";
    }

    @RequestMapping(value="/download/{id}")
    public ResponseEntity<byte[]> download(@PathVariable int id,HttpServletRequest request)throws Exception {
        String filename = (userService.load(id)).getAttachs();
        //下载文件路径
        String path = request.getServletContext().getRealPath("/accessorykit");
        //创建下载文件的对象
        File file = new File(path + File.separator + filename);
        //创建Http信息传Header包装对象
        HttpHeaders headers = new HttpHeaders();
        //下载显示的文件名，解决中文名称乱码问题
        String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        //通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFielName);
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
    }
}
