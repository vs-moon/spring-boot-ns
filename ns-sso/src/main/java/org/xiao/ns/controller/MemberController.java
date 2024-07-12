package org.xiao.ns.controller;

import com.github.pagehelper.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.xiao.cs.common.box.domain.ArgsState;
import org.xiao.cs.common.box.domain.CommonRequest;
import org.xiao.cs.common.box.domain.CommonRequestPaging;
import org.xiao.cs.db.box.service.entry.EntryService;
import org.xiao.ns.domain.po.Member;
import org.xiao.ns.service.MemberService;

import java.util.List;

@RestController
@RequestMapping("member")
public class MemberController implements EntryService<Member> {

    @Resource
    MemberService memberService;

    @Override
    @PostMapping("deleteOne")
    public int deleteOne(@RequestBody CommonRequest<Long> record) {
        return memberService.deleteOne(record.getArgs());
    }

    @Override
    @PostMapping("deleteMany")
    public int deleteMany(@RequestBody CommonRequest<List<Long>> record) {
        return memberService.deleteMany(record.getArgs());
    }

    @Override
    @PostMapping("insertOne")
    public int insertOne(@RequestBody CommonRequest<Member> record) {
        return memberService.insertOne(record.getArgs());
    }

    @Override
    @PostMapping("insertMany")
    public int insertMany(@RequestBody CommonRequest<List<Member>> record) {
        return memberService.insertMany(record.getArgs());
    }

    @Override
    @PostMapping("selectOne")
    public Member selectOne(@RequestBody CommonRequest<Long> record) {
        return memberService.selectOne(record.getArgs());
    }

    @Override
    @PostMapping("selectMany")
    public List<Member> selectMany(@RequestBody CommonRequest<Member> record) {
        return memberService.selectMany(record.getArgs());
    }

    @Override
    @PostMapping("selectPage")
    public Page<Member> selectPage(@RequestBody CommonRequestPaging<Member> record) {
        return memberService.selectPage(record.getArgs(), record.getPaging().getPageNum(), record.getPaging().getPageSize());
    }

    @Override
    @PostMapping("updateOne")
    public int updateOne(@RequestBody CommonRequest<Member> record) {
        return memberService.updateOne(record.getArgs());
    }

    @Override
    @PostMapping("updateMany")
    public int updateMany(@RequestBody CommonRequest<List<Member>> record) {
        return memberService.updateMany(record.getArgs());
    }

    @Override
    @PostMapping("validOne")
    public int validOne(@RequestBody CommonRequest<ArgsState<Long, String>> record) {
        return memberService.validOne(record.getArgs());
    }

    @Override
    @PostMapping("validMany")
    public int validMany(@RequestBody CommonRequest<ArgsState.Many<Long, String>> record) {
        return memberService.validMany(record.getArgs());
    }
}
