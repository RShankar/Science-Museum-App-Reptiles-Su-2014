package edu.fau.group5.bugs;

import java.util.Locale;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

	SectionsPagerAdapter mSectionsPagerAdapter;
	ViewPager mViewPager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
	}
	
	protected void onResume() {
		super.onResume();
		if(getIntent().hasExtra("position")) {
			mViewPager.setCurrentItem(getIntent().getExtras().getInt("position"));
		}
	}
	
	protected void onNewIntent(Intent intent) {
		mViewPager.setCurrentItem(intent.getExtras().getInt("position"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public class SectionsPagerAdapter extends FragmentStatePagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment = new BugSectionFragment();
			Bundle args = new Bundle();
			args.putInt(BugSectionFragment.ARG_SECTION_NUMBER, position + 1);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			return 11;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);
			case 2:
				return getString(R.string.title_section3).toUpperCase(l);
			case 3:
				return getString(R.string.title_section4).toUpperCase(l);
			case 4:
				return getString(R.string.title_section5).toUpperCase(l);
			case 5:
				return getString(R.string.title_section6).toUpperCase(l);
			case 6:
				return getString(R.string.title_section7).toUpperCase(l);
			case 7:
				return getString(R.string.title_section8).toUpperCase(l);
			case 8:
				return getString(R.string.title_section9).toUpperCase(l);
			case 9:
				return getString(R.string.title_section10).toUpperCase(l);
			case 10:
				return getString(R.string.title_section11).toUpperCase(l);
			}
			return null;
		}
	}

	public static class BugSectionFragment extends Fragment {
		private View rootView;
		private ImageView bugImageView;
		public static final String ARG_SECTION_NUMBER = "section_number";

		public BugSectionFragment(){  }
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			rootView = inflater.inflate(R.layout.fragment_main_bug_exhibit, container, false);
			bugImageView = (ImageView) rootView.findViewById(R.id.bugImageView);
			
			switch (getArguments().getInt(ARG_SECTION_NUMBER) - 1) {
			case 0:
				bugImageView.setImageResource(R.drawable.african_flat_rock_scorpion);
				break;
			case 1:
				bugImageView.setImageResource(R.drawable.asian_forest_scorpion);
				break;
			case 2:
				bugImageView.setImageResource(R.drawable.emperor_scorpion);
				break;
			case 3:
				bugImageView.setImageResource(R.drawable.tailless_whip_scorpion);
				break;
			case 4:
				bugImageView.setImageResource(R.drawable.red_claw_scorpion);
				break;
			case 5:
				bugImageView.setImageResource(R.drawable.madagascar_hissing_cockroach);
				break;
			case 6:
				bugImageView.setImageResource(R.drawable.mexican_red_knee_tarantula);
				break;
			case 7:
				bugImageView.setImageResource(R.drawable.mexican_blond_tarantula);
				break;
			case 8:
				bugImageView.setImageResource(R.drawable.pink_toe_tarantula);
				break;
			case 9:
				bugImageView.setImageResource(R.drawable.rose_haired_tarantula);
				break;
			case 10:
				bugImageView.setImageResource(R.drawable.florida_ivory_millipede);
				break;
			}
			
			TextView dummyTextView = (TextView) rootView.findViewById(R.id.exhibit_info);
			dummyTextView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)) + " " + getString(R.string.lorem_ipsum));
			return rootView;
		}
	}
}
