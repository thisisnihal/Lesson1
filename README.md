### CS50 Android Track Lesson 1

* [x] Step 1 Add `Track.java` file    
```java
// it's just a data class
public class Track {
    private String name;
    private String instructor;

    Track(String name, String instructor) {
        this.name = name;
        this.instructor = instructor;
    }
    public String getName() {
        return name;
    }
    public String getInstructor() {
        return instructor;
    }
}
```
* [x] Step 2 Update `MainActivity.java` file   
```java
public class MainActivity extends AppCompatActivity {

    TextView tv1;
    Button btn1;
    String strfortv = "";

    List<Track> tracks = new ArrayList<>();
    List<String> students = Arrays.asList("Harry", "Ron", "Harmione");

    Map<String, Track> assignments  = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tracks.add(new Track("Mobile", "Tommy"));
        tracks.add(new Track("Web", "Brian"));
        tracks.add(new Track("Games", "Colton"));

        tv1 = findViewById(R.id.tv1);
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                change();
            }
        });
    }
    void change() {
        Random random = new Random();
        for (String student : students) {
            int index = random.nextInt(tracks.size());
            assignments.put(student, tracks.get(index));
        }

        for (Map.Entry<String, Track> entry : assignments.entrySet()) {
            Track track = entry.getValue();
            String debugMsg = entry.getKey() + " got " + track.getName() + " with " +
                    track.getInstructor();
            Log.d("cs50", debugMsg );
            strfortv += debugMsg + "\n";
        }
        tv1.setText(strfortv);
        strfortv = "";
    }
}
```  
* [x] Step 3 Update `activity_main.xml` file  
```xml
<TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Click Change Button"
        android:id="@+id/tv1"
        android:textSize="30sp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintLeft_toLeftOf="parent"
        app:layout_constraintRight_toRightOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <Button
        android:id="@+id/btn1"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Change"
        android:textSize="30sp"
        android:layout_marginTop="32dp"
        app:layout_constraintEnd_toEndOf="@+id/tv1"
        app:layout_constraintStart_toStartOf="@+id/tv1"
        app:layout_constraintTop_toBottomOf="@+id/tv1" />
```  


***Note: I am still Learning so what I explained above take it as a pinch of salt. There is NO GAURANTEE & WARRANTY of the information given above : )***
