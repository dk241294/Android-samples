package com.example.intentsusingparcelable;
import android.os.Parcel;
import android.os.Parcelable;

  public class Person implements Parcelable {
      private String FirstName;
      private String LastName;
      private String Qualification;


      public Person() {
          super();
      }

      public Person(Parcel parcel) {
          this.FirstName = parcel.readString();
          this.LastName = parcel.readString();
          this.Qualification = parcel.readString();
      }

      @Override
      public int describeContents() {
          return 0;
      }

      @Override
      public void writeToParcel(Parcel parcel, int i) {
          parcel.writeString(this.FirstName);
          parcel.writeString(this.LastName);
          parcel.writeString(this.Qualification);
      }

      public static final Creator<Person> CREATOR = new Creator<Person>() {
          @Override
          public Person createFromParcel(Parcel parcel) {
              return new Person(parcel);
          }

          @Override
          public Person[] newArray(int i) {
              return new Person[i];
          }
      };

      public String getFirstName() {
          return FirstName;
      }

      public void setFirstName(String firstName) {
          this.FirstName = firstName;
      }

      public String getLastName() {
          return LastName;
      }

      public void setLastName(String lastName) {
          this.LastName = lastName;
      }

      public String getQualification() {
          return Qualification;
      }

      public void setQualification(String qualification) {
          this.Qualification = qualification;
      }
  }

