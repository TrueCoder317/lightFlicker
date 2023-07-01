using UnityEngine;
using System.Collections;

public class LightFlicker : MonoBehaviour
{
    public Light flashlight;
    public float minWaitTime;
    public float maxWaitTime;

    private bool isFlickering;

    void Start()
    {
        isFlickering = false;

        if (flashlight == null)
        {
            flashlight = GetComponent<Light>();
        }
    }

    void Update()
    {
        if (!isFlickering)
        {
            StartCoroutine(Flicker());
        }
    }

    IEnumerator Flicker()
    {
        isFlickering = true;

        while (true)
        {
            yield return new WaitForSeconds(Random.Range(minWaitTime, maxWaitTime));

            flashlight.enabled = false;

            yield return new WaitForSeconds(Random.Range(0.1f, 0.2f));

            flashlight.enabled = true;
        }

        isFlickering = false;
    }
}
