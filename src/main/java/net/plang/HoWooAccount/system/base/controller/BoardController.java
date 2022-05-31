package net.plang.HoWooAccount.system.base.controller;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import net.plang.HoWooAccount.system.base.serviceFacade.BaseServiceFacade;
import net.plang.HoWooAccount.system.base.to.BoardBean;
import net.plang.HoWooAccount.system.base.to.MenuBean;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/base")
public class BoardController {

    @Autowired
    private BaseServiceFacade baseServiceFacade;

    @PostMapping("/findBoardList")
    public ArrayList<BoardBean> findBoardList() {
        return baseServiceFacade.findBoardList();
    }

    @GetMapping("/findPost")
    public HashMap<String, Object> findPost(@RequestParam String boardNum) {
        return baseServiceFacade.findPost(boardNum);
    }

    @PostMapping("/registBoard")
    public HashMap<String, String> registBoard(@RequestParam(value = "sendData") String boardData, @RequestParam(value = "fileSendData", required = false) String fileData) {
        System.out.println("boardData = " + boardData);
        ArrayList<BoardBean> arrayList = new ArrayList<>();
        Gson gson = new Gson();
        BoardBean bean = gson.fromJson(boardData, BoardBean.class);
        baseServiceFacade.registBoard(bean);
        if(fileData != null){
            System.out.println("fileData = " + fileData);
            System.out.println("게시판 파일 데이터 INSERT");
            JSONArray jsonArray = JSONArray.fromObject(fileData);
            System.out.println("jsonArray = " + jsonArray);
            for(Object file : jsonArray){
                BoardBean fileBean = new BoardBean();
                fileBean = gson.fromJson(file.toString(), BoardBean.class);
                arrayList.add(fileBean);
            }
            baseServiceFacade.boardFileUpload(arrayList);
        }
        return new HashMap<>();
    }
}
