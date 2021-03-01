package com.bafdev.javaquizz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends Fragment {

    private Context mContext;

    Button mButtonA;
    Button mButtonB;
    Button mButtonC;
    Button mButtonD;

    ProgressBar mProgressBar;
    TextView mTextViewScore;
    TextView mTextViewQuestion;

    int mScore;
    int mQuestion;
    int mIndex;

    Shuffle mShuffle = new Shuffle();
    private Questions[] mQuestions = mShuffle.shuffledQuestions();

    final int PROGRESS_BAR_INCREMENT = (int) Math.ceil(100.0/mQuestions.length);

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MainFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MainFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        if (savedInstanceState != null) {
            mScore = savedInstanceState.getInt("ScoreKey");
            mIndex = savedInstanceState.getInt("IndexKey");
        }
        else {
            mScore = 0;
            mIndex = 0;
        }

        mButtonA = view.findViewById(R.id.buttonA);
        mButtonB = view.findViewById(R.id.buttonB);
        mButtonC = view.findViewById(R.id.buttonC);
        mButtonD = view.findViewById(R.id.buttonD);

        mProgressBar = view.findViewById(R.id.progressBar);
        mTextViewScore = view.findViewById(R.id.score);
        mTextViewQuestion = view.findViewById(R.id.question_text_view);

        mQuestion = mQuestions[mIndex].getQuestionId();
        mTextViewQuestion.setText(mQuestion);
        mTextViewScore.setText("Score: " + mScore + "/" + mQuestions.length);

        mButtonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer('a');
                updateQuestion();
            }
        });

        mButtonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer('b');
                updateQuestion();
            }
        });

        mButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer('c');
                updateQuestion();
            }
        });

        mButtonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer('d');
                updateQuestion();
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    @SuppressLint("SetTextI18n")
    private void updateQuestion() {
        mIndex = (mIndex + 1) % mQuestions.length;

        FinishFragment finishFragment = new FinishFragment();

        if (mIndex == 0) {
            ((MainActivity) Objects.requireNonNull(getActivity())).replaceFragments(finishFragment);
        }

        mQuestion = mQuestions[mIndex].getQuestionId();
        mTextViewQuestion.setText(mQuestion);
        mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        mTextViewScore.setText("Score: " + mScore + "/" + mQuestions.length);
    }

    private void checkAnswer(char userSelection) {
        char correctAnswer = mQuestions[mIndex].getAnswer();

        if (userSelection == correctAnswer) {
            Toast.makeText(mContext,R.string.correct_toast,Toast.LENGTH_SHORT).show();
            mScore++;
        }
        else
            Toast.makeText(mContext,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("ScoreKey", mScore);
        outState.putInt("IndexKey", mIndex);
    }
}