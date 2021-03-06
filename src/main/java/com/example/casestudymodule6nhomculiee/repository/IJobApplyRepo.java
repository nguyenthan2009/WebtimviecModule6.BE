package com.example.casestudymodule6nhomculiee.repository;

import com.example.casestudymodule6nhomculiee.model.Entity.JobApply;
import com.example.casestudymodule6nhomculiee.model.Entity.RecruitmentPost;
import com.example.casestudymodule6nhomculiee.model.Entity.UserProfile;
import com.example.casestudymodule6nhomculiee.model.User.AppRole;
import com.example.casestudymodule6nhomculiee.model.User.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IJobApplyRepo extends JpaRepository<JobApply,Long> {
    @Query("select a from JobApply a where a.recuitmentPost = ?1 and a.status= ?2" )
    List<JobApply> getJobAppliesByRecuitmentPostAndStatus(RecruitmentPost recruitmentPost, boolean status);

    @Query("select a from JobApply a where a.recuitmentPost = ?1 and a.appUser= ?2" )
    JobApply pickUserProfile(RecruitmentPost recruitmentPost, AppUser appUser);

    @Query("select a from JobApply a where a.appUser = ?1 and a.status= ?2" )
    List<JobApply> notify(AppUser appUser, boolean status);

    @Query("select a from JobApply a where a.appUser = ?1 and a.status= ?2" )
    List<JobApply> Save(AppUser appUser, boolean status);

}
