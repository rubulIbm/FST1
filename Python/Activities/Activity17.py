#import pandas
import pandas

#create dictonary that holds data 
data= {
    "Usernames":["admin","Charles","Deku"],
    "Passwords":["password","Charl13","AllMight"]

}
#create dataframe using that data
dataframe=pandas.DataFrame(data)

#print the data frame
print(dataframe)
"""
 Write the DataFrame to a CSV file
 To avoid writing the index numbers to the file as well
 the index property is set to false
"""
dataframe.to_csv("sample.csv",index=False)