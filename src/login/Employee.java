/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author Akshay mehta
 */
public class Employee {
    
    String mId;
    String mRating;
    public Employee(String id,String rating)
    {
        mId = id;
        mRating = rating;
    }
 
    public String getId()
    {
        return mId;
    }
    public String getRating()
    {
        return mRating;
    }
}
