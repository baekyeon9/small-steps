package com.share.ftp;

import java.util.List;


public class CommBestListHandler implements Command {

  List<CommBoardDTO> commBoardDTOList;     
  public CommBestListHandler (List<CommBoardDTO> commBoardDTOList) {
    this.commBoardDTOList = commBoardDTOList;
  }      

  @Override
  public void execute(CommandRequest request) throws Exception {

    System.out.println("[소통해요/나눔이야기Best/목록]");

    //    //  전체 목록중에서 조회수가 가장 높은 3개
    //    CommBoardDTO[] arr = commBoardHandler.chooseBoard();
    //
    //    System.out.printf("%d, %s, %s, %s, %s, %d\n", 
    //        arr[0].getNo(), 
    //        arr[0].getTitle(), 
    //        arr[0].getContent(),
    //        arr[0].getFileUpload(),
    //        //this.commBoardsDTO[i].getPassword(),
    //        arr[0].getRegisteredDate(), 
    //        arr[0].getViewCount());
  }
}