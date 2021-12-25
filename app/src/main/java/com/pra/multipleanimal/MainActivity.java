package com.pra.multipleanimal;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.ar.core.Anchor;
import com.google.ar.core.HitResult;
import com.google.ar.core.Plane;
import com.google.ar.sceneform.AnchorNode;
import com.google.ar.sceneform.math.Vector3;
import com.google.ar.sceneform.rendering.ModelRenderable;
import com.google.ar.sceneform.rendering.ViewRenderable;
import com.google.ar.sceneform.ux.ArFragment;
import com.google.ar.sceneform.ux.BaseArFragment;
import com.google.ar.sceneform.ux.TransformableNode;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArFragment arFragment;

    private ModelRenderable bearRenderable,
            catRenderable,
            cowRenderable,
            dogRenderable,
            elephantRenderable,
            ferretRenderable,
            hippoRenderable,
            horseRenderable,
            koalaRenderable,
            lionRenderable,
            reindeerRenderable,
            wolverineRenderable;

    private ImageView ivBear, ivCat, ivCow, ivDog, ivElephant, ivFerret, ivHippo, ivHorse, ivKoala, ivLion, ivReindeer, ivWolverine;

    private View arrayview[];


    int selected = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arFragment = (ArFragment) getSupportFragmentManager().findFragmentById(R.id.sceneform_ux_fragment);

        // view
        ivBear = findViewById(R.id.ivBear);
        ivCat = findViewById(R.id.ivCat);
        ivCow = findViewById(R.id.ivCow);
        ivDog = findViewById(R.id.ivDog);
        ivElephant = findViewById(R.id.ivElephant);
        ivFerret = findViewById(R.id.ivFerret);
        ivHippo = findViewById(R.id.ivHippo);
        ivHorse = findViewById(R.id.ivHorse);
        ivKoala = findViewById(R.id.ivKoalaBear);
        ivLion = findViewById(R.id.ivLion);
        ivReindeer = findViewById(R.id.ivReindeer);
        ivWolverine = findViewById(R.id.ivWolverine);

        setArrayView();
        setClickListener();
        setupModel();

        arFragment.setOnTapArPlaneListener(new BaseArFragment.OnTapArPlaneListener() {
            @Override
            public void onTapPlane(HitResult hitResult, Plane plane, MotionEvent motionEvent) {
                //if (selected == 1) {
                Anchor anchor = hitResult.createAnchor();
                AnchorNode anchorNode = new AnchorNode(anchor);
                anchorNode.setParent(arFragment.getArSceneView().getScene());
                createModel(anchorNode, selected);
                //}
            }
        });
    }

    private void createModel(AnchorNode anchorNode, int selected) {
        if (selected == 1) {
            TransformableNode bear = new TransformableNode(arFragment.getTransformationSystem());
            bear.setParent(anchorNode);
            bear.setRenderable(bearRenderable);
            bear.select();
            addName(anchorNode, bear, "Bear");
        }

        if (selected == 2) {
            TransformableNode cat = new TransformableNode(arFragment.getTransformationSystem());
            cat.setParent(anchorNode);
            cat.setRenderable(catRenderable);
            cat.select();
            addName(anchorNode, cat, "Cat");
        }

        if (selected == 3) {
            TransformableNode cow = new TransformableNode(arFragment.getTransformationSystem());
            cow.setParent(anchorNode);
            cow.setRenderable(cowRenderable);
            cow.select();
            addName(anchorNode, cow, "Cow");
        }

        if (selected == 4) {
            TransformableNode dog = new TransformableNode(arFragment.getTransformationSystem());
            dog.setParent(anchorNode);
            dog.setRenderable(dogRenderable);
            dog.select();
            addName(anchorNode, dog, "Dog");
        }

        if (selected == 5) {
            TransformableNode elephant = new TransformableNode(arFragment.getTransformationSystem());
            elephant.setParent(anchorNode);
            elephant.setRenderable(elephantRenderable);
            elephant.select();
            addName(anchorNode, elephant, "Elephant");
        }

        if (selected == 6) {
            TransformableNode ferret = new TransformableNode(arFragment.getTransformationSystem());
            ferret.setParent(anchorNode);
            ferret.setRenderable(ferretRenderable);
            ferret.select();
            addName(anchorNode, ferret, "Ferret");
        }

        if (selected == 7) {
            TransformableNode hippo = new TransformableNode(arFragment.getTransformationSystem());
            hippo.setParent(anchorNode);
            hippo.setRenderable(hippoRenderable);
            hippo.select();
            addName(anchorNode, hippo, "Hippopotamus");
        }

        if (selected == 8) {
            TransformableNode horse = new TransformableNode(arFragment.getTransformationSystem());
            horse.setParent(anchorNode);
            horse.setRenderable(horseRenderable);
            horse.select();
            addName(anchorNode, horse, "Horse");
        }

        if (selected == 9) {
            TransformableNode koala_bear = new TransformableNode(arFragment.getTransformationSystem());
            koala_bear.setParent(anchorNode);
            koala_bear.setRenderable(koalaRenderable);
            koala_bear.select();
            addName(anchorNode, koala_bear, "Koala Bear");
        }

        if (selected == 10) {
            TransformableNode lion = new TransformableNode(arFragment.getTransformationSystem());
            lion.setParent(anchorNode);
            lion.setRenderable(lionRenderable);
            lion.select();
            addName(anchorNode, lion, "Lion");
        }


        if (selected == 11) {
            TransformableNode reindeer = new TransformableNode(arFragment.getTransformationSystem());
            reindeer.setParent(anchorNode);
            reindeer.setRenderable(reindeerRenderable);
            reindeer.select();
            addName(anchorNode, reindeer, "Reindeer");
        }


        if (selected == 12) {
            TransformableNode Wolverine = new TransformableNode(arFragment.getTransformationSystem());
            Wolverine.setParent(anchorNode);
            Wolverine.setRenderable(wolverineRenderable);
            Wolverine.select();
            addName(anchorNode, Wolverine, "Wolverine");
        }
    }


    private void addName(AnchorNode anchorNode, TransformableNode model, String name) {
        ViewRenderable.builder()
                .setView(this, R.layout.name_animal)
                .build()
                .thenAccept(renderable -> {

                    TransformableNode nameView = new TransformableNode(arFragment.getTransformationSystem());
                    nameView.setLocalPosition(new Vector3(0f, model.getLocalPosition().y + 0.5f, 0));
                    nameView.setParent(anchorNode);
                    nameView.setRenderable(renderable);
                    nameView.select();

                    // set text
                    TextView txt_name = (TextView) renderable.getView();
                    txt_name.setText(name);

                    txt_name.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            anchorNode.setParent(null);
                        }
                    });

                    //name_animal = renderable
                });


    }


    private void setArrayView() {
        arrayview = new View[]{
                ivBear, ivCat, ivCow, ivDog, ivElephant, ivFerret, ivHippo, ivHorse, ivKoala, ivLion, ivReindeer, ivWolverine
        };
    }

    private void setClickListener() {
        for (int i = 0; i < arrayview.length; i++) {
            arrayview[i].setOnClickListener(this);
        }
    }


    private void setupModel() {
        ModelRenderable.builder().
                setSource(this, Uri.parse("bear.sfb"))
                .build().thenAccept(renderable -> bearRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(this, "Unable to load bear model", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;
                        }
                );


        ModelRenderable.builder().
                setSource(this, Uri.parse("cat.sfb"))
                .build().thenAccept(renderable -> catRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(this, "Unable to load cat model", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;
                        }
                );


        ModelRenderable.builder().
                setSource(this, Uri.parse("cow.sfb"))
                .build().thenAccept(renderable -> cowRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(this, "Unable to load cow model", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();

                            return null;
                        }
                );

        ModelRenderable.builder().
                setSource(this, Uri.parse("dog.sfb"))
                .build().thenAccept(renderable -> dogRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(this, "Unable to load dog model", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();

                            return null;
                        }
                );

        ModelRenderable.builder().
                setSource(this, Uri.parse("elephant.sfb"))
                .build().thenAccept(renderable -> elephantRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(this, "Unable to load elephant model", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;
                        }
                );


        ModelRenderable.builder().
                setSource(this, Uri.parse("ferret.sfb"))
                .build().thenAccept(renderable -> ferretRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(this, "Unable to load ferret model", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;
                        }
                );


        ModelRenderable.builder().
                setSource(this, Uri.parse("hippopotamus.sfb"))
                .build().thenAccept(renderable -> hippoRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(this, "Unable to load hippo model", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();

                            return null;
                        }
                );


        ModelRenderable.builder().
                setSource(this, Uri.parse("horse.sfb"))
                .build().thenAccept(renderable -> horseRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(this, "Unable to load horse model", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();

                            return null;
                        }
                );


        ModelRenderable.builder().
                setSource(this, Uri.parse("koala_bear.sfb"))
                .build().thenAccept(renderable -> koalaRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(this, "Unable to load koala bear model", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;
                        }
                );


        ModelRenderable.builder().
                setSource(this, Uri.parse("lion.sfb"))
                .build().thenAccept(renderable -> lionRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(this, "Unable to load lion model", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;
                        }
                );


        ModelRenderable.builder().
                setSource(this, Uri.parse("reindeer.sfb"))
                .build().thenAccept(renderable -> reindeerRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(this, "Unable to load reindeer model", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();

                            return null;
                        }
                );


        ModelRenderable.builder().
                setSource(this, Uri.parse("wolverine.sfb"))
                .build().thenAccept(renderable -> wolverineRenderable = renderable)
                .exceptionally(
                        throwable -> {
                            Toast toast = Toast.makeText(this, "Unable to load wolverine model", Toast.LENGTH_SHORT);
                            toast.setGravity(Gravity.CENTER, 0, 0);
                            toast.show();
                            return null;
                        }
                );
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.ivBear) {
            selected = 1;
            setBackground(v.getId());
        } else if (v.getId() == R.id.ivCat) {
            selected = 2;
            setBackground(v.getId());
        } else if (v.getId() == R.id.ivCow) {
            selected = 3;
            setBackground(v.getId());
        } else if (v.getId() == R.id.ivDog) {
            selected = 4;
            setBackground(v.getId());
        } else if (v.getId() == R.id.ivElephant) {
            selected = 5;
            setBackground(v.getId());
        } else if (v.getId() == R.id.ivFerret) {
            selected = 6;
            setBackground(v.getId());
        } else if (v.getId() == R.id.ivHippo) {
            selected = 7;
            setBackground(v.getId());
        } else if (v.getId() == R.id.ivHorse) {
            selected = 8;
            setBackground(v.getId());
        } else if (v.getId() == R.id.ivKoalaBear) {
            selected = 9;
            setBackground(v.getId());
        } else if (v.getId() == R.id.ivLion) {
            selected = 10;
            setBackground(v.getId());
        } else if (v.getId() == R.id.ivReindeer) {
            selected = 11;
            setBackground(v.getId());
        } else if (v.getId() == R.id.ivWolverine) {
            selected = 12;
            setBackground(v.getId());
        }
    }

    private void setBackground(int id) {
        for (int i = 0; i < arrayview.length; i++) {
            if (arrayview[i].getId() == id) {
                arrayview[i].setBackgroundColor(Color.parseColor("#80333639"));
            } else {
                arrayview[i].setBackgroundColor(Color.TRANSPARENT);
            }
        }
    }
}