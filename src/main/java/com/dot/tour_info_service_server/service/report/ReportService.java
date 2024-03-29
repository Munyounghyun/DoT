package com.dot.tour_info_service_server.service.report;

import com.dot.tour_info_service_server.dto.request.report.DisciplinaryRequestDTO;
import com.dot.tour_info_service_server.dto.request.report.ReportRequestDTO;
import com.dot.tour_info_service_server.dto.response.report.DisciplinaryAllResponseDTO;
import com.dot.tour_info_service_server.dto.response.report.ReportAllResponseDTO;
import com.dot.tour_info_service_server.dto.response.report.ReportResponseDTO;
import com.dot.tour_info_service_server.entity.Report;

import java.util.List;

public interface ReportService {
    //신고 필터 조회
    List<ReportResponseDTO> reportFilter(int page, String filter, String search);

    //해당 신고 내역 정보 조회
    ReportAllResponseDTO reportDetail(Long sno);

    //해당 회원 제재조회
    List<DisciplinaryAllResponseDTO> disciplinaryUserData(Long mno);

    //신고(게시글 or 댓글)
    Long report(ReportRequestDTO reportRequestDTO);

    //신고 상태 업데이트
    Long reportUpdate(Long sno);

    //제재
    Long disciplinary(DisciplinaryRequestDTO disciplinaryRequestDTO);

    default ReportAllResponseDTO entityToDto(Report report){
        return ReportAllResponseDTO.builder()
                .sno(report.getSno())
                .complainant(report.getComplainant_mno())
                .defendant(report.getDefendant_mno())
                .bno(report.getBoard_bno()!=null?report.getBoard_bno():null)
                .rno(report.getReply_rno()!=null?report.getReply_rno():null)
                .content(report.getContent())
                .isDone(report.getIsDone())
                .message(report.getMessage())
                .regDate(report.getRegDate())
                .build();
    }
}
