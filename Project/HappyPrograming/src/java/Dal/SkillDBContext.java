/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Entity.Skill;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class SkillDBContext extends DBContext<Skill>{
    public ArrayList<Skill> list(){
        ArrayList<Skill> list = new ArrayList<>();
        return list;
    }
}
