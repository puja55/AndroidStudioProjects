package com.example.pri.molomartnew.Adapter;

/**
 * Created by User on 16/09/2016.
 */

import android.animation.Animator;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pri.molomartnew.Fragments.FragmentImgZoom;
import com.example.pri.molomartnew.R;

import java.util.List;

/**
 * Created by Ravi Tamada on loading/05/16.
 */
public class Adapter_Image_Gallery extends RecyclerView.Adapter<Adapter_Image_Gallery.MyViewHolder> {



    private Animator mCurrentAnimatorEffect;
    private int mShortAnimationDurationEffect;

    private Context mContext;
    private List<Data_Image_Gallery> albumList;
    FragmentTransaction mFragmentTransaction;
    FragmentManager mFragmentManager;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
//            title = (TextView) view.findViewById(R.id.title);

            thumbnail = (ImageView) view.findViewById(R.id.thumbnail);


//            thumbnail.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    zoomImageFromThumb(thumbnail, R.drawable.architecture);
//                }
//            });
//
//            mShortAnimationDurationEffect = view.getResources().getInteger(
//                    android.R.integer.config_shortAnimTime);
//
//        }
//
//        @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
//        private void zoomImageFromThumb(final View thumbView, int imageResId) {
//            if (mCurrentAnimatorEffect != null) {
//                mCurrentAnimatorEffect.cancel();
//            }
//
//            final ImageView expandedImageView = (ImageView)itemView.findViewById(
//                    R.id.expanded_image);
//            expandedImageView.setScaleType(ImageView.ScaleType.FIT_XY);
//            expandedImageView.setImageResource(imageResId);
//
//            final Rect startBounds = new Rect();
//            final Rect finalBounds = new Rect();
//            final Point globalOffset = new Point();
//
//            thumbView.getGlobalVisibleRect(startBounds);
//            itemView.findViewById(R.id.framealbumcard)
//                    .getGlobalVisibleRect(finalBounds, globalOffset);
//            startBounds.offset(-globalOffset.x, -globalOffset.y);
//            finalBounds.offset(-globalOffset.x, -globalOffset.y);
//
//            float startScale;
//            if ((float) finalBounds.width() / finalBounds.height()
//                    > (float) startBounds.width() / startBounds.height()) {
//                // Extend start bounds horizontally
//                startScale = (float) startBounds.height() / finalBounds.height();
//                float startWidth = startScale * finalBounds.width();
//                float deltaWidth = (startWidth - startBounds.width()) / 2;
//                startBounds.left -= deltaWidth;
//                startBounds.right += deltaWidth;
//            } else {
//                // Extend start bounds vertically
//                startScale = (float) startBounds.width() / finalBounds.width();
//                float startHeight = startScale * finalBounds.height();
//                float deltaHeight = (startHeight - startBounds.height()) / 2;
//                startBounds.top -= deltaHeight;
//                startBounds.bottom += deltaHeight;
//            }
//
//            thumbView.setAlpha(0f);
//            expandedImageView.setVisibility(View.VISIBLE);
//
//            expandedImageView.setPivotX(0f);
//            expandedImageView.setPivotY(0f);
//
//            // scale properties (X, Y, SCALE_X, and SCALE_Y).
//            AnimatorSet set = new AnimatorSet();
//            set
//                    .play(ObjectAnimator.ofFloat(expandedImageView, View.X,
//                            startBounds.left, finalBounds.left))
//                    .with(ObjectAnimator.ofFloat(expandedImageView, View.Y,
//                            startBounds.top, finalBounds.top))
//                    .with(ObjectAnimator.ofFloat(expandedImageView, View.SCALE_X,
//                            startScale, 1f)).with(ObjectAnimator.ofFloat(expandedImageView,
//                    View.SCALE_Y, startScale, 1f));
//            set.setDuration(mShortAnimationDurationEffect);
//            set.setInterpolator(new DecelerateInterpolator());
//            set.addListener(new AnimatorListenerAdapter() {
//                @Override
//                public void onAnimationEnd(Animator animation) {
//                    mCurrentAnimatorEffect = null;
//                }
//
//                @Override
//                public void onAnimationCancel(Animator animation) {
//                    mCurrentAnimatorEffect = null;
//                }
//            });
//            set.start();
//            mCurrentAnimatorEffect = set;
//
//            final float startScaleFinal = startScale;
//            expandedImageView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (mCurrentAnimatorEffect != null) {
//                        mCurrentAnimatorEffect.cancel();
//                    }
//
//                    // back to their original values.
//                    AnimatorSet set = new AnimatorSet();
//                    set.play(ObjectAnimator
//                            .ofFloat(expandedImageView, View.X, startBounds.left))
//                            .with(ObjectAnimator
//                                    .ofFloat(expandedImageView,
//                                            View.Y,startBounds.top))
//                            .with(ObjectAnimator
//                                    .ofFloat(expandedImageView,
//                                            View.SCALE_X, startScaleFinal))
//                            .with(ObjectAnimator
//                                    .ofFloat(expandedImageView,
//                                            View.SCALE_Y, startScaleFinal));
//                    set.setDuration(mShortAnimationDurationEffect);
//                    set.setInterpolator(new DecelerateInterpolator());
//                    set.addListener(new AnimatorListenerAdapter() {
//                        @Override
//                        public void onAnimationEnd(Animator animation) {
//                            thumbView.setAlpha(1f);
//                            expandedImageView.setVisibility(View.GONE);
//                            mCurrentAnimatorEffect = null;
//                        }
//
//                        @Override
//                        public void onAnimationCancel(Animator animation) {
//                            thumbView.setAlpha(1f);
//                            expandedImageView.setVisibility(View.GONE);
//                            mCurrentAnimatorEffect = null;
//                        }
//                    });
//                    set.start();
//                    mCurrentAnimatorEffect = set;
//                }
//            });
//        }
//

        }
    }


    public Adapter_Image_Gallery(Context mContext, List<Data_Image_Gallery> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.frag_img_gallery_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Data_Image_Gallery album = albumList.get(position);
        // holder.title.setText(album.getName());


        // loading album cover using Glide library
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);
        holder.thumbnail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentImgZoom fragmentList=new FragmentImgZoom();
                // mFragmentManager =((Activity)mContext).getFragmentManager();
                mFragmentManager=  ((AppCompatActivity)mContext).getSupportFragmentManager();
                mFragmentTransaction = mFragmentManager.beginTransaction();
                mFragmentTransaction.replace(R.id.frame,fragmentList, "list").addToBackStack("List").commit();
            }
        });

    }

    /**
     * Showing popup menu when tapping on 3 dots
     */

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}